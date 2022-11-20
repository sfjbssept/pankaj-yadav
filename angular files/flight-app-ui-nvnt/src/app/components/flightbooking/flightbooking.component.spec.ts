import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightbookingComponent } from './flightbooking.component';

describe('FlightbookingComponent', () => {
  let component: FlightbookingComponent;
  let fixture: ComponentFixture<FlightbookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightbookingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlightbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
