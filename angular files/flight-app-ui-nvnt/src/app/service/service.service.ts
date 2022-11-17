import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  login(data: any): Observable<any> {
    return this.http.post('https://jsonplaceholder.typicode.com/posts', data).pipe(map((resp) => {
      return resp;
    }));
  }
}
