import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './material-module';
import { FlexLayoutModule } from '@angular/flex-layout';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { RootsearchComponent } from './rootsearch/rootsearch.component';
import { ConjugationGroupComponent } from './conjugation-group/conjugation-group.component';
import { TrilateralConjugationPanelComponent } from './trilateral-conjugation-panel/trilateral-conjugation-panel.component';
import { QuadilateralConjugationPanelComponent } from './quadilateral-conjugation-panel/quadilateral-conjugation-panel.component';
import { StartComponent } from './start/start.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { InitialSarfComponent } from './initial-sarf/initial-sarf.component';
import { ActiveVerbsComponent } from './active-verbs/active-verbs.component';
import { SarfVerbPronounsComponent } from './sarf-verb-pronouns/sarf-verb-pronouns.component';
import { PassiveVerbsComponent } from './passive-verbs/passive-verbs.component';
import { DerivedNounsComponent } from './derived-nouns/derived-nouns.component';
import { NounsListingComponent } from './nouns-listing/nouns-listing.component';
import { GerundsComponent } from './gerunds/gerunds.component';

const appRoutes: Routes = [
  {path: '', component: StartComponent},
  {path: 'tri/:root', component: TrilateralConjugationPanelComponent},
  {path: 'quad/:root', component: QuadilateralConjugationPanelComponent},
  {path: 'verb/tri/u/:verb/:class', component: InitialSarfComponent},
  {path: 'verb/tri/u/:verb/:class/active', component: ActiveVerbsComponent},
  {path: 'verb/tri/u/:verb/:class/passive', component: PassiveVerbsComponent},
  {path: 'verb/tri/u/:verb/:class/nouns', component: DerivedNounsComponent},
  {path: 'verb/tri/u/:verb/:class/gerunds', component: GerundsComponent},
  {path: 'verb/tri/a/:verb/:formula', component: InitialSarfComponent},
  {path: 'verb/tri/a/:verb/:formula/active', component: ActiveVerbsComponent},
  {path: 'verb/tri/a/:verb/:formula/passive', component: PassiveVerbsComponent},
  {path: 'verb/tri/a/:verb/:formula/nouns', component: DerivedNounsComponent},
  {path: 'verb/tri/a/:verb/:formula/gerunds', component: GerundsComponent},
  {path: 'verb/quad/u/:verb', component: InitialSarfComponent},
  {path: 'verb/quad/u/:verb/active', component: ActiveVerbsComponent},
  {path: 'verb/quad/u/:verb/passive', component: PassiveVerbsComponent},
  {path: 'verb/quad/u/:verb/nouns', component: DerivedNounsComponent},
  {path: 'verb/quad/u/:verb/gerunds', component: GerundsComponent},
  {path: 'verb/quad/a/:verb/:formula', component: InitialSarfComponent},
  {path: 'verb/quad/a/:verb/:formula/active', component: ActiveVerbsComponent},
  {path: 'verb/quad/a/:verb/:formula/passive', component: PassiveVerbsComponent},
  {path: 'verb/quad/a/:verb/:formula/nouns', component: DerivedNounsComponent},
  {path: 'verb/quad/a/:verb/:formula/gerunds', component: GerundsComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    RootsearchComponent,
    ConjugationGroupComponent,
    TrilateralConjugationPanelComponent,
    QuadilateralConjugationPanelComponent,
    StartComponent,
    NotFoundComponent,
    InitialSarfComponent,
    ActiveVerbsComponent,
    SarfVerbPronounsComponent,
    PassiveVerbsComponent,
    DerivedNounsComponent,
    NounsListingComponent,
    GerundsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    FlexLayoutModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {onSameUrlNavigation: 'reload'})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
