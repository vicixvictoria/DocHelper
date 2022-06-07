import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLabValueComponent } from './add-lab-value.component';

describe('AddLabValueComponent', () => {
  let component: AddLabValueComponent;
  let fixture: ComponentFixture<AddLabValueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddLabValueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLabValueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
