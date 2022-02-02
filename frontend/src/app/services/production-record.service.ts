import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';
import {environment} from "src/environments/environment";
import {ProductionRecord} from "../model/productionRecord";

@Injectable({
  providedIn: 'root'
})
export class ProductionRecordService {
  private url = environment.url;

  constructor(private http: HttpClient){}

  public saveProductionRecordsByPlotId(plotId: string, productionRecord: ProductionRecord): Observable<ProductionRecord> {
    return this.http.post<ProductionRecord>(`${this.url}/v1/plots/${plotId}/production-records`, productionRecord);
  }

  public findProductionRecordsByPlotId(plotId: string): Observable<ProductionRecord[]> {
    return this.http.get<ProductionRecord[]>(`${this.url}/v1/plots/${plotId}/production-records`);
  }
}
