import { TestBed } from '@angular/core/testing';

import { SearchflightService } from './searchflight.service';

describe('SearchflightService', () => {
  let service: SearchflightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchflightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
