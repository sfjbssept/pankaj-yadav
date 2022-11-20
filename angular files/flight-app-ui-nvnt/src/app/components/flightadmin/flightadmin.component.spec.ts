import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightadminComponent } from './flightadmin.component';

describe('FlightadminComponent', () => {
  let component: FlightadminComponent;
  let fixture: ComponentFixture<FlightadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightadminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlightadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
