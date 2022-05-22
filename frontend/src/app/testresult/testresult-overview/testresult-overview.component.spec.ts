import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestresultOverviewComponent } from './testresult-overview.component';

describe('TestresultOverviewComponent', () => {
  let component: TestresultOverviewComponent;
  let fixture: ComponentFixture<TestresultOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestresultOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestresultOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
