import {Component, OnInit} from '@angular/core';
import { Farm } from './model/farm';
import {FarmService} from './services/farm.service';
import {PlotService} from './services/plot.service';
import {ProductivityService} from './services/productivity.service';
import { NgForm } from '@angular/forms';
import {ProductionRecord} from "./model/productionRecord";
import {ProductionRecordService} from "./services/production-record.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'frontend';
  public farms: Farm[];
  public plots: any;
  public productionRecords: ProductionRecord[];
  public showPlotsOfFarm: any;
  public productivityByPlot: any;
  public productivityByFarm: any;
  public showProductivity: boolean;
  public selectedFarmId: string;
  public selectedPlotId: string;

  constructor(
    private farmService: FarmService,
    private plotService: PlotService,
    private productivityService: ProductivityService,
    private productionRecordService: ProductionRecordService
    ){
    this.farms = [];
    this.plots = {};
    this.productionRecords = [];
    this.showPlotsOfFarm = {};
    this.showProductivity = false;
    this.productivityByPlot = {};
    this.productivityByFarm = {};
    this.selectedFarmId = '';
    this.selectedPlotId = '';
  }

  ngOnInit(): void {
    this.findFarms();
  }

  public findFarms(): void {
    this.farmService.findFarms().subscribe({
      next: (response) => {
        this.farms = response.content;
        this.farms.forEach(item => this.showPlotsOfFarm[item.id] = false);
      },
      error: (error) => alert(error.message)
    })
  }

  public findProductionRecords(plotId: string): void {
    this.selectedPlotId = plotId;
    this.productionRecordService.findProductionRecordsByPlotId(plotId).subscribe({
      next: (response) => {
        this.productionRecords = response;
      },
      error: (error) => alert(error.message)
    })
  }

  public findPlotsByFarm(farmId: string): void {
    this.plotService.findPlots(farmId).subscribe({
      next: (response) => {
        this.plots[farmId] = response;
      }
    })
  }

  public calculateProductivityByFarm(farmId: string): void {
    this.productivityService.calculateProductivityByFarmId(farmId).subscribe({
      next: (response) => {
        this.productivityByFarm = response;
        this.productivityByPlot = null;
        this.showProductivity = true;
      }
    })
  }

  public calculateProductivityByPlot(plotId: string): void {
    this.productivityService.calculateProductivityByPlotId(plotId).subscribe({
      next: (response) => {
        this.productivityByPlot = response;
        this.productivityByFarm = null;
        this.showProductivity = true;
      }
    })
  }

  public togglePlot(farmId: string): void {
    if(this.showPlotsOfFarm[farmId]) {
      this.findPlotsByFarm(farmId);
    }
    this.showPlotsOfFarm[farmId] = !this.showPlotsOfFarm[farmId];
  }

  public onAddFarm(form: NgForm): void {
    this.farmService.saveFarm(form.value).subscribe({
      next: (response) => {
        this.farms.push(response)
        this.farms.forEach(item => this.showPlotsOfFarm[item.id] = false);
        this.findFarms();
      },
      error: (error) => alert(error.message)
    })
  }

  public onAddPlot(form: NgForm, farmId: string): void {
    this.plotService.savePlot(farmId, form.value).subscribe({
      next: (_) => {
        this.findFarms();
        this.findPlotsByFarm(farmId);
        this.showPlotsOfFarm[farmId] = true;
      },
      error: (error) => alert(error.message)
    })
  }

  public onAddProductionRecord(form: NgForm, plotId: string): void {
    this.productionRecordService.saveProductionRecordsByPlotId(plotId, form.value).subscribe({
      next: (_) => {
        this.findProductionRecords(plotId);
      },
      error: (error) => alert(error.message)
    })
  }


  public setSelectedFarmId(farmId: string) {
    this.selectedFarmId = farmId;
  }
}
