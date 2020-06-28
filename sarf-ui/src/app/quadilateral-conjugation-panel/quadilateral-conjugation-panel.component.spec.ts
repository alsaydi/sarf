import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuadilateralConjugationPanelComponent } from './quadilateral-conjugation-panel.component';

describe('QuadilateralConjugationPanelComponent', () => {
  let component: QuadilateralConjugationPanelComponent;
  let fixture: ComponentFixture<QuadilateralConjugationPanelComponent>;

  beforeEach(async(() => {
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
