import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';

@Injectable({
  providedIn: 'root'
})
export class SarfService {

  constructor(private httpClient: HttpClient) {
  }

  findSarf(root: string): Observable<any> {
    console.info('searching for ' + root);
    return this.httpClient.get('/sarf/' + encodeURIComponent(root));
  }

  getActiveVerbConjugatons(verbSelectionDetail: VerbSelectionDetail): Observable<any> {
    console.info(`active verb conjugations for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
    return this.httpClient.get(`/sarf/active/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`)
  }
}
