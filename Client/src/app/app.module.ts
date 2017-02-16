import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent}  from './app.component';
import {UserListComponent} from './user-list/user-list.component';
import {UserDetailComponent} from './user-detail/user-detail.component';
import {NotFoundComponent} from './not-found/not-found.component';

import {UserService} from './user-service/user.service';
import {MovieService} from './movie-service/movie.service';
import {MovieCreateComponent} from "./movie-create/movie-create.component";
import {MovieDeleteComponent} from "./movie-delete/movie-delete.component";
import {MovieListComponent} from "./movie-update/movie-list.component";
import {MovieUpdateComponent} from "./movie-update/movie-update.component";
import {MovieListHomeComponent} from "./movie-list/movie-list-home.component";
import {MovieListTopRatedComponent} from "./movie-list/movie-list-toprated.component";
import {MovieListTopRatedTvComponent} from "./movie-list/movie-list-topratedtv.component";
import {MovieDetailComponent} from "./movie-detail/movie-detail.component";


const appRoutes: Routes = [
    {path: 'home', component: MovieListHomeComponent},
    {path: 'topratedmovie', component: MovieListTopRatedComponent},
    {path: 'topratedtv', component: MovieListTopRatedTvComponent},
    {path: 'createmovie', component: MovieCreateComponent},
    {path: 'deletemovie', component: MovieDeleteComponent},
    {path: 'updatemovie', component: MovieListComponent},
    {path: 'updatemovie/:id', component: MovieUpdateComponent},
    {path: 'users', component: UserListComponent},
    {path: 'users/:id', component: UserDetailComponent},
    {path: 'home/:id', component: MovieDetailComponent},
    {path: 'topratedmovie/:id', component: MovieDetailComponent},
    {path: 'topratedtv/:id', component: MovieDetailComponent},

    {path: '', redirectTo: 'createmovie', pathMatch: 'full'},
    {path: '**', component: NotFoundComponent}
];

@NgModule({
    imports: [BrowserModule, HttpModule, RouterModule.forRoot(appRoutes),FormsModule],
    declarations: [AppComponent, UserListComponent, UserDetailComponent, NotFoundComponent,MovieCreateComponent,MovieListComponent,MovieUpdateComponent, MovieDeleteComponent,MovieListTopRatedComponent,MovieListTopRatedTvComponent,MovieListHomeComponent, MovieDetailComponent],
    providers: [UserService, MovieService],
    bootstrap: [AppComponent]
})
export class AppModule {
}

console.log('Running');
