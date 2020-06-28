import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrilateralConjugationPanelComponent } from './trilateral-conjugation-panel.component';

describe('TrilateralConjugationPanelComponent', () => {
  let component: TrilateralConjugationPanelComponent;
  let fixture: ComponentFixture<TrilateralConjugationPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrilateralConjugationPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrilateralConjugationPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
