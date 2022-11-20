import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarleaseComponent } from './carlease.component';

describe('CarleaseComponent', () => {
  let component: CarleaseComponent;
  let fixture: ComponentFixture<CarleaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarleaseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarleaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
