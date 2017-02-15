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
const movie_service_1 = require('../movie-service/movie.service');
let MovieDeleteComponent = class MovieDeleteComponent {
    constructor(movieService) {
        this.movieService = movieService;
        this.movieList = [];
        movieService.getMovies()
            .subscribe(movies => this.movieList = movies, error => console.log(error));
    }
    submit() {
        this.movieService.DeleteMovie(this.value).subscribe(movies => this.movie = movies, error => console.log(error));
    }
};
MovieDeleteComponent = __decorate([
    core_1.Component({
        templateUrl: '/movie-delete.component.html'
    }), 
    __metadata('design:paramtypes', [movie_service_1.MovieService])
], MovieDeleteComponent);
exports.MovieDeleteComponent = MovieDeleteComponent;
//# sourceMappingURL=movie-delete.component.js.map