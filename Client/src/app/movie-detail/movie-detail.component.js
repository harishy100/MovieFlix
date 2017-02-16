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
let MovieDetailComponent = class MovieDetailComponent {
    constructor(route, movieService) {
        this.route = route;
        this.movieService = movieService;
        this.movie = {};
        this.commentsList = {};
        this.comment = {};
        this.route.params.subscribe(params => {
            movieService.getMovieById(params['id'])
                .subscribe(movie => this.movie = movie, error => console.log(error));
        });
    }
    imdblink() {
        let imdblink = "";
        console.log(this.movie.director);
        console.log(this.movie);
        imdblink = "http://www.imdb.com/title/" + this.movie.imdbId;
        window.location.href = imdblink;
    }
    viewcomments() {
        this.movieService.getCommentsById(this.movie.id)
            .subscribe(comments => this.commentsList = comments, error => console.log(error));
    }
    postcomment() {
        this.comment.movie = this.movie;
        this.comment.comment = this.value;
        this.movieService.postcomments(this.comment)
            .subscribe(comments => this.commentsList = comments, error => console.log(error));
    }
    userrating() {
        this.movieService.getratingsById(this.movie.id)
            .subscribe(comments => this.rating = comments, error => console.log(error));
    }
    postrating() {
        this.comment.movie = this.movie;
        this.comment.comment = this.value1;
        this.movieService.postrating(this.comment)
            .subscribe(comments => this.rating = comments, error => console.log(error));
    }
};
MovieDetailComponent = __decorate([
    core_1.Component({
        templateUrl: '/movie-detail.component.html'
    }), 
    __metadata('design:paramtypes', [router_1.ActivatedRoute, movie_service_1.MovieService])
], MovieDetailComponent);
exports.MovieDetailComponent = MovieDetailComponent;
//# sourceMappingURL=movie-detail.component.js.map