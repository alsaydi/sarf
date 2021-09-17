import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppNotificationsService {

  constructor() { }

  private rootResultSource = new Subject<any>();
  rootResultRetrieved$ = this.rootResultSource.asObservable();

  broadcastRootResult(rootResult) {
    this.rootResultSource.next(rootResult);
  }
}
