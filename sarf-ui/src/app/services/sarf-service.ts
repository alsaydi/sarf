import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SarfService {

  constructor(private httpClient: HttpClient) {
  }

  findTrilateralConjugations(root: string): Observable<any> {
    console.info('searching for ' + root);
    return this.httpClient.get('/sarf/' + encodeURIComponent(root));
  }
}
