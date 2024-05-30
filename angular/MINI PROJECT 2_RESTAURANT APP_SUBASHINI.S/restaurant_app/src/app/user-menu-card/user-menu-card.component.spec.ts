import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatCardModule } from '@angular/material/card';

import { UserMenuCardComponent } from './user-menu-card.component';
import {By} from '@angular/platform-browser';

describe('UserMenuCardComponent', () => {
  let component: UserMenuCardComponent;
  let fixture: ComponentFixture<UserMenuCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserMenuCardComponent ],
      imports:[MatCardModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserMenuCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should have mat-card as header',() =>{
    let card = fixture.debugElement.query(By.css('mat-card'))
    expect(card).toBeTruthy();
  })

});
