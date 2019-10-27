import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-hello-gradle',
  templateUrl: './hello-gradle.component.html',
  styleUrls: ['./hello-gradle.component.css']
})
export class HelloGradleComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get('/').subscribe(res => {
      console.log('Im waiting for something :', res);
    });
  }

}
