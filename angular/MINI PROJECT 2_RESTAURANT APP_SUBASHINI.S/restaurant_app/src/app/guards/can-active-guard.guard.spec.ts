import { TestBed } from '@angular/core/testing';

import { CanActiveGuardGuard } from './can-active-guard.guard';

describe('CanActiveGuardGuard', () => {
  let guard: CanActiveGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CanActiveGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
