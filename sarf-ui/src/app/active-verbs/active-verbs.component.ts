/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import { Component, OnDestroy, OnInit, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Utils } from '../models/Utils';
import { VerbConjugation } from '../models/VerbConjugation';
import { AppNotificationsService } from '../services/app-notifications.service';
import { SarfService } from '../services/sarf-service';

@Component({
  selector: 'app-active-verbs',
  templateUrl: './active-verbs.component.html',
  styleUrls: ['./active-verbs.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class ActiveVerbsComponent implements OnInit, OnDestroy {

  private serviceSubscription: Subscription;
  public pastGroups: Array<VerbConjugation>;
  public nominativePresentGroups: Array<VerbConjugation>;
  public accusativePresentGroups: Array<VerbConjugation>;
  public jussivePresentGroups: Array<VerbConjugation>;
  public emphasizedPresentGroups: Array<VerbConjugation>;
  public imperativeGroups: Array<VerbConjugation>;
  public emphasizedImperativeGroups: Array<VerbConjugation>;

  constructor(private sarfService: SarfService, private route: ActivatedRoute, private appNotificationsService: AppNotificationsService) { }

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.serviceSubscription = this.sarfService.getActiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
      console.log('active verbs' , result);
      this.pastGroups = result.map(r => ({key: r.key, verbs: r.past}));
      this.nominativePresentGroups = result.map(r => ({key: r.key, verbs: r.nominativePresent}));
      this.accusativePresentGroups = result.map(r => ({key: r.key, verbs: r.accusativePresent}));
      this.jussivePresentGroups = result.map(r => ({key: r.key, verbs: r.jussivePresent}));;
      this.emphasizedPresentGroups = result.map(r => ({key: r.key, verbs: r.emphasizedPresent}));
      this.imperativeGroups = result.map(r => ({key: r.key, verbs: r.imperative}));
      this.emphasizedImperativeGroups = result.map(r => ({key: r.key, verbs: r.emphasizedImperative}));
    });
    this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
  }

  showSubTabs(): boolean {
    return this.pastGroups.length > 1;
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }

  ngOnDestroy(): void {
    this.serviceSubscription?.unsubscribe();
  }
}
