import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';

@Injectable({
  providedIn: 'root'
})
export class SarfService {

  private currentResult: any;
  constructor(private httpClient: HttpClient) {
  }

  findSarf(root: string): Observable<any> {    
    console.info('searching for ' + root);
    this.currentResult = this.httpClient.get('/sarf/' + encodeURIComponent(root));
    return this.currentResult;
  } 
}
