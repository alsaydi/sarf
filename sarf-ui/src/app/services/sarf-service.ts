import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SarfService {
  
  private readonly apiUrl: string;
  constructor(private httpClient: HttpClient) {
    this.apiUrl = environment.apiUrl;
  }

  findSarf(root: string): Observable<any> {
    console.info('searching for ' + root);
    return this.httpClient.get(this.apiUrl + '/sarf/' + encodeURIComponent(root));
  }

  getActiveVerbConjugatons(verbSelectionDetail: VerbSelectionDetail): Observable<any> {
    console.info(`active verb conjugations for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
    return this.httpClient.get(`${this.apiUrl}/sarf/active/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
  }

  getPassiveVerbConjugatons(verbSelectionDetail: VerbSelectionDetail): Observable<any> {
    console.info(`passive verb conjugations for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
    return this.httpClient.get(`${this.apiUrl}/sarf/passive/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
  }

  getDerivedNouns(verbSelectionDetail: VerbSelectionDetail): Observable<any> {
    console.info(`derived nouns for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
    return this.httpClient.get(`${this.apiUrl}/sarf/nouns/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
  }

  getGerunds(verbSelectionDetail: VerbSelectionDetail): Observable<any> {
    console.info(`gerunds for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
    return this.httpClient.get(`${this.apiUrl}/sarf/gerunds/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
  }
}
