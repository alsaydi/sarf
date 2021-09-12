import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TrilateralConjugationPanelComponent } from './trilateral-conjugation-panel.component';

describe('TrilateralConjugationPanelComponent', () => {
  let component: TrilateralConjugationPanelComponent;
  let fixture: ComponentFixture<TrilateralConjugationPanelComponent>;

  beforeEach(waitForAsync(() => {
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
