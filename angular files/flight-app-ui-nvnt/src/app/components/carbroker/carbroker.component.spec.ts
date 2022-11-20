import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarbrokerComponent } from './carbroker.component';

describe('CarbrokerComponent', () => {
  let component: CarbrokerComponent;
  let fixture: ComponentFixture<CarbrokerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarbrokerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarbrokerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
