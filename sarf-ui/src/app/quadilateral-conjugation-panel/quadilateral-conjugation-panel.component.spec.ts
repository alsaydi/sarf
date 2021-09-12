import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { QuadilateralConjugationPanelComponent } from './quadilateral-conjugation-panel.component';

describe('QuadilateralConjugationPanelComponent', () => {
  let component: QuadilateralConjugationPanelComponent;
  let fixture: ComponentFixture<QuadilateralConjugationPanelComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ QuadilateralConjugationPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuadilateralConjugationPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
