import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlighcreateComponent } from './flighcreate.component';

describe('FlighcreateComponent', () => {
  let component: FlighcreateComponent;
  let fixture: ComponentFixture<FlighcreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlighcreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlighcreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
