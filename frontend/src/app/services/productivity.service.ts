import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { environment } from "src/environments/environment";
import { Productivity } from "../model/productivity";

@Injectable({
    providedIn: 'root'
})
export class ProductivityService {
  private url = environment.url;

  constructor(private http: HttpClient){}

  public calculateProductivityByFarmId(farmId: string): Observable<Productivity[]> {
    return this.http.get<any>(`${this.url}/v1/farms/${farmId}/productivity`);
  }

  public calculateProductivityByPlotId(plotId: string): Observable<Productivity> {
    return this.http.get<any>(`${this.url}/v1/plots/${plotId}/productivity`);
  }
}
