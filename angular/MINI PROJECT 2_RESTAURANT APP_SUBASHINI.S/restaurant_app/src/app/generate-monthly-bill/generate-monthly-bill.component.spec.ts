import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateMonthlyBillComponent } from './generate-monthly-bill.component';

describe('GenerateMonthlyBillComponent', () => {
  let component: GenerateMonthlyBillComponent;
  let fixture: ComponentFixture<GenerateMonthlyBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenerateMonthlyBillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerateMonthlyBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
