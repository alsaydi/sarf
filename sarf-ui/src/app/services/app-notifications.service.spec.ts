import { TestBed } from '@angular/core/testing';

import { AppNotificationsService } from './app-notifications.service';

describe('AppNotificationsService', () => {
  let service: AppNotificationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppNotificationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
