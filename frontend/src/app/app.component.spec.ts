import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { of } from 'rxjs';
import { CalculationApiService } from './services/calculation-api.service';

describe('AppComponent', () => {
  const calculationApiServiceMock = {
    getCalculation: jasmine.createSpy().and.returnValue(of({ result: 20 })),
    getHealth: jasmine.createSpy().and.returnValue(of({ status: 'UP' }))
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
      providers: [
        { provide: CalculationApiService, useValue: calculationApiServiceMock }
      ]
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should load result and health on init', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    app.ngOnInit();
    expect(app.result).toBe(20);
    expect(app.healthStatus).toBe('UP');
  });
});
