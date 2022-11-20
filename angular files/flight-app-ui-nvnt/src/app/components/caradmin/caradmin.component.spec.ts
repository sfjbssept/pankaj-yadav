import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaradminComponent } from './caradmin.component';

describe('CaradminComponent', () => {
  let component: CaradminComponent;
  let fixture: ComponentFixture<CaradminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CaradminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaradminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
