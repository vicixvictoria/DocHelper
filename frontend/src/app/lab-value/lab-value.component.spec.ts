import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabValueComponent } from './lab-value.component';

describe('LabValueComponent', () => {
  let component: LabValueComponent;
  let fixture: ComponentFixture<LabValueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LabValueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LabValueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
