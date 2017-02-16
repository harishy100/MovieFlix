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
const router_1 = require('@angular/router');
const movie_service_1 = require('../movie-service/movie.service');
let MovieUpdateComponent = class MovieUpdateComponent {
    constructor(route, movieService) {
        this.route = route;
        this.movieService = movieService;
        this.mve = {};
        this.movie = {};
        this.route.params.subscribe(params => {
            this.id = params['id'];
            movieService.getMovieById(params['id'])
                .subscribe(mve => this.mve = mve, error => console.log(error));
        });
    }
    onsubmit() {
        //To format the input object in the required form for the server.
        let array;
        let i = 0;
        let array1;
        this.movie.id = this.id;
        array = this.movie.genres.split(',');
        array1 = this.movie.actors.split(',');
        this.movie.genres = [];
        this.movie.actors = [];
        while (i < array.length) {
            this.movie.genres.push({ genrename: array[i] });
            i++;
        }
        i = 0;
        while (i < array1.length) {
            this.movie.actors.push({ actor: array1[i] });
            i++;
        }
        this.movieService.updateMovie(this.movie);
    }
};
MovieUpdateComponent = __decorate([
    core_1.Component({
        templateUrl: '/movie-update.component.html'
    }), 
    __metadata('design:paramtypes', [router_1.ActivatedRoute, movie_service_1.MovieService])
], MovieUpdateComponent);
exports.MovieUpdateComponent = MovieUpdateComponent;
//# sourceMappingURL=movie-update.component.js.map