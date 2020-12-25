import { TestBed } from '@angular/core/testing';

import { SarfService } from './sarf-service';

describe('SarfServiceService', () => {
  let service: SarfService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SarfService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
