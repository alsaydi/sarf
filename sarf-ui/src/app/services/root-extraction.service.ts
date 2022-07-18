import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RootExtractionService {

  private readonly rootExtServiceUrl: string;
  constructor(private httpClient: HttpClient) {
    this.rootExtServiceUrl = environment.rootExtUrl;
  }

  findRoot(word: string): Observable<any> {
    // TODO: add a logger instead of console.x
    console.info('extracting root from ' + word);
    return this.httpClient.get(this.rootExtServiceUrl + '/root-ext/' + encodeURIComponent(word));
  }
}
