import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { VerbSelectionDetail } from '../models/VerbSelectionDetail';


@Injectable({
  providedIn: 'root'
})
export class AppNotificationsService {

  constructor() { }

  private rootResultSource = new Subject<any>();
  private verbSelectedSource = new Subject<VerbSelectionDetail>();

  rootResultRetrieved$ = this.rootResultSource.asObservable();
  verbSelected$ = this.verbSelectedSource.asObservable();

  broadcastRootResult(rootResult) {
    this.rootResultSource.next(rootResult);
  }

  broadcastVerbSelected(verb: VerbSelectionDetail) {
    this.verbSelectedSource.next(verb);
  }
}
