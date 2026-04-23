import { Component, OnInit } from '@angular/core';
import { finalize } from 'rxjs';
import { CalculationApiService } from './services/calculation-api.service';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  result: number | null = null;
  healthStatus = '-';
  isLoading = false;
  errorMessage = '';

  constructor(private readonly calculationApiService: CalculationApiService) {}

  ngOnInit(): void {
    this.refreshData();
  }

  refreshData(): void {
    this.errorMessage = '';
    this.isLoading = true;

    this.calculationApiService
      .getCalculation()
      .pipe(finalize(() => (this.isLoading = false)))
      .subscribe({
        next: (response) => {
          this.result = response.result;
        },
        error: () => {
          this.errorMessage = 'Impossible de recuperer le resultat de calcul.';
          this.result = null;
        }
      });

    this.calculationApiService.getHealth().subscribe({
      next: (response) => {
        this.healthStatus = response.status;
      },
      error: () => {
        this.healthStatus = 'DOWN';
      }
    });
  }
}
