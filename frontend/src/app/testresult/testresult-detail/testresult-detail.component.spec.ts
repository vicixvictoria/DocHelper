import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestresultDetailComponent } from './testresult-detail.component';

describe('TestresultDetailComponent', () => {
  let component: TestresultDetailComponent;
  let fixture: ComponentFixture<TestresultDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestresultDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestresultDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
