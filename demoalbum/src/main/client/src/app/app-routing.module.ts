import { NgModule } from "@angular/core";
import { Routes, RouterModule } from '@angular/router';

import { AlbumComponent } from '../album/album.component';

const routes: Routes = [
    { path: 'album', component: AlbumComponent },

    // otherwise redirect to album until we add some more features and functionality
    { path: '**', redirectTo: 'album' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes,
        { enableTracing: false } // <-- debugging purposes only
    )],
    exports: [RouterModule]
})
export class AppRoutingModule
{

}