import { Component } from '@angular/core';
import { environment } from '../environments/environment';
import {MatLegacyDialog as MatDialog, MatLegacyDialogRef as MatDialogRef, MAT_LEGACY_DIALOG_DATA as MAT_DIALOG_DATA} from '@angular/material/legacy-dialog';
import { AboutComponent } from './about/about.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public dialog: MatDialog) {
    console.log(environment);
  }
  title = 'صرف';
  

  showAbout() {
    let dialogRef = this.dialog.open(AboutComponent, {
      height: '400px',
      width: '600px',
    });
  }
}
