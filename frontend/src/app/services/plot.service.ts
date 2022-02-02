import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from "src/environments/environment";
import {Observable} from 'rxjs';
import {Plot} from './../model/plot';

@Injectable({
  providedIn: 'root'
})
export class PlotService {

  private url = environment.url;

  constructor(private http: HttpClient){}

  public findPlots(farmId: string): Observable<Plot[]> {
    return this.http.get<Plot[]>(`${this.url}/v1/farms/${farmId}/plots`);
  }

  public savePlot(farmId: string, plot: Plot): Observable<Plot> {
    return this.http.post<Plot>(`${this.url}/v1/farms/${farmId}/plots`, plot);
  }
}
