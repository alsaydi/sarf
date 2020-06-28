import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConjugationGroupComponent } from './conjugation-group.component';

describe('ConjugationGroupComponent', () => {
  let component: ConjugationGroupComponent;
  let fixture: ComponentFixture<ConjugationGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConjugationGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConjugationGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
