import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppNotificationsService {

  constructor() { }

  private rootResultSource = new Subject<any>();
  private verbSelectedSource = new Subject<any>();

  rootResultRetrieved$ = this.rootResultSource.asObservable();
  verbSelected$ = this.verbSelectedSource.asObservable();
  

  broadcastRootResult(rootResult) {
    this.rootResultSource.next(rootResult);
  }

  broadcastVerbSelected(message) {
    this.verbSelectedSource.next(message);
  }
}
