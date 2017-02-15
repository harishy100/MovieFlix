"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
const core_1 = require('@angular/core');
const http_1 = require('@angular/http');
const forms_1 = require('@angular/forms');
const router_1 = require('@angular/router');
const platform_browser_1 = require('@angular/platform-browser');
const app_component_1 = require('./app.component');
const user_list_component_1 = require('./user-list/user-list.component');
const user_detail_component_1 = require('./user-detail/user-detail.component');
const not_found_component_1 = require('./not-found/not-found.component');
const user_service_1 = require('./user-service/user.service');
const movie_service_1 = require('./movie-service/movie.service');
const movie_create_component_1 = require("./movie-create/movie-create.component");
const movie_delete_component_1 = require("./movie-delete/movie-delete.component");
const movie_list_component_1 = require("./movie-update/movie-list.component");
const movie_update_component_1 = require("./movie-update/movie-update.component");
const movie_list_home_component_1 = require("./movie-list/movie-list-home.component");
const movie_list_toprated_component_1 = require("./movie-list/movie-list-toprated.component");
const movie_list_topratedtv_component_1 = require("./movie-list/movie-list-topratedtv.component");
const movie_detail_component_1 = require("./movie-detail/movie-detail.component");
const appRoutes = [
    { path: 'home', component: movie_list_home_component_1.MovieListHomeComponent },
    { path: 'topratedmovie', component: movie_list_toprated_component_1.MovieListTopRatedComponent },
    { path: 'topratedtv', component: movie_list_topratedtv_component_1.MovieListTopRatedTvComponent },
    { path: 'createmovie', component: movie_create_component_1.MovieCreateComponent },
    { path: 'deletemovie', component: movie_delete_component_1.MovieDeleteComponent },
    { path: 'updatemovie', component: movie_list_component_1.MovieListComponent },
    { path: 'updatemovie/:id', component: movie_update_component_1.MovieUpdateComponent },
    { path: 'users', component: user_list_component_1.UserListComponent },
    { path: 'users/:id', component: user_detail_component_1.UserDetailComponent },
    { path: 'home/:id', component: movie_detail_component_1.MovieDetailComponent },
    { path: 'topratedmovie/:id', component: movie_detail_component_1.MovieDetailComponent },
    { path: 'topratedtv/:id', component: movie_detail_component_1.MovieDetailComponent },
    { path: '', redirectTo: 'createmovie', pathMatch: 'full' },
    { path: '**', component: not_found_component_1.NotFoundComponent }
];
let AppModule = class AppModule {
};
AppModule = __decorate([
    core_1.NgModule({
        imports: [platform_browser_1.BrowserModule, http_1.HttpModule, router_1.RouterModule.forRoot(appRoutes), forms_1.FormsModule],
        declarations: [app_component_1.AppComponent, user_list_component_1.UserListComponent, user_detail_component_1.UserDetailComponent, not_found_component_1.NotFoundComponent, movie_create_component_1.MovieCreateComponent, movie_list_component_1.MovieListComponent, movie_update_component_1.MovieUpdateComponent, movie_delete_component_1.MovieDeleteComponent, movie_list_toprated_component_1.MovieListTopRatedComponent, movie_list_topratedtv_component_1.MovieListTopRatedTvComponent, movie_list_home_component_1.MovieListHomeComponent, movie_detail_component_1.MovieDetailComponent],
        providers: [user_service_1.UserService, movie_service_1.MovieService],
        bootstrap: [app_component_1.AppComponent]
    }), 
    __metadata('design:paramtypes', [])
], AppModule);
exports.AppModule = AppModule;
console.log('Running');
//# sourceMappingURL=app.module.js.map