import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface CalculationResponse {
  result: number;
}

export interface StatusResponse {
  status: string;
}

@Injectable({
  providedIn: 'root'
})
export class CalculationApiService {
  private readonly baseUrl = 'http://localhost:8080/api/v1';

  constructor(private readonly http: HttpClient) {}

  getCalculation(): Observable<CalculationResponse> {
    return this.http.get<CalculationResponse>(`${this.baseUrl}/calculation`);
  }

  getHealth(): Observable<StatusResponse> {
    return this.http.get<StatusResponse>(`${this.baseUrl}/health`);
  }
}
