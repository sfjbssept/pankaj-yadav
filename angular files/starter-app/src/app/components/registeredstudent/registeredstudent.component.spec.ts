import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteredstudentComponent } from './registeredstudent.component';

describe('RegisteredstudentComponent', () => {
  let component: RegisteredstudentComponent;
  let fixture: ComponentFixture<RegisteredstudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisteredstudentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisteredstudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
