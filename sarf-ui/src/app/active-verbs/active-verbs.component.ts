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
  public past: Array<string>;
  public nominativePresent: Array<string>;
  public accusativePresent: Array<string>;
  public jussivePresent: Array<string>;
  public emphasizedPresent: Array<string>;
  public imperative: Array<string>;
  public emphasizedImperative: Array<string>;

  constructor(private sarfService: SarfService, private route: ActivatedRoute, private appNotificationsService: AppNotificationsService) { }  

  ngOnInit(): void {
    const verbSelectionDetail = this.getVerbSelectionDetail();
    this.serviceSubscription = this.sarfService.getActiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
      console.log(result);
      this.past = result.past;
      this.nominativePresent = result.nominativePresent;
      this.accusativePresent = result.accusativePresent;
      this.jussivePresent = result.jussivePresent;
      this.emphasizedPresent = result.emphasizedPresent
      this.imperative = result.imperative
      this.emphasizedImperative = result.emphasizedImperative
    });
    this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
  }

  private getVerbSelectionDetail() {
    return Utils.getVerbSelectionDetail(this.route);
  }

  ngOnDestroy(): void {
    this.serviceSubscription?.unsubscribe();
  }
}
