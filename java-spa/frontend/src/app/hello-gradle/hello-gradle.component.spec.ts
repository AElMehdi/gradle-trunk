import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloGradleComponent } from './hello-gradle.component';

describe('HelloGradleComponent', () => {
  let component: HelloGradleComponent;
  let fixture: ComponentFixture<HelloGradleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelloGradleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelloGradleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
