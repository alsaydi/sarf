import { NgModule } from '@angular/core';
import { MatToolbarModule, MatFormFieldModule, MatInputModule } from '@angular/material';

@NgModule({
    exports: [
        MatToolbarModule,
        MatFormFieldModule,
        MatInputModule
    ]
})
export class AppMaterialModule { }
