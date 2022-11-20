import { TestBed } from '@angular/core/testing';

import { FlightserviceService } from './flightservice.service';

describe('FlightserviceService', () => {
  let service: FlightserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlightserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
