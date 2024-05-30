import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenetareTodayBillComponent } from './genetare-today-bill.component';

describe('GenetareTodayBillComponent', () => {
  let component: GenetareTodayBillComponent;
  let fixture: ComponentFixture<GenetareTodayBillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenetareTodayBillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenetareTodayBillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
