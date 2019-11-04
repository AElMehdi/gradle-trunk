import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelloGradleComponent } from './hello-gradle.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

describe('HelloGradleComponent', () => {
  let component: HelloGradleComponent;
  let fixture: ComponentFixture<HelloGradleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelloGradleComponent ],
      imports: [ HttpClientModule ]
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
