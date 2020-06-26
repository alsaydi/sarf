import { NgModule } from '@angular/core';
import { MatToolbarModule
    , MatFormFieldModule
    , MatInputModule
    , MatCardModule
    , MatGridListModule } from '@angular/material';

@NgModule({
    exports: [
        MatToolbarModule,
        MatFormFieldModule,
        MatInputModule,
        MatCardModule,
        MatGridListModule
    ]
})
export class AppMaterialModule { }
