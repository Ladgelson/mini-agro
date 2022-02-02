import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Farm } from "../model/farm";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class FarmService {
    private url = environment.url;

    constructor(private http: HttpClient){}

    public findFarms(): Observable<any> {
        return this.http.get<any>(`${this.url}/v1/farms`);
    }

    public saveFarm(farm: Farm): Observable<Farm> {
        return this.http.post<Farm>(`${this.url}/v1/farms`, farm);
    }
}