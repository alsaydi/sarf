import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RootsearchComponent } from './rootsearch.component';

describe('RootsearchComponent', () => {
  let component: RootsearchComponent;
  let fixture: ComponentFixture<RootsearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RootsearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RootsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
