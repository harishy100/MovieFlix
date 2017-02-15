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
const Observable_1 = require('rxjs/Observable');
require('rxjs/add/operator/catch');
require('rxjs/add/operator/map');
require('rxjs/add/observable/throw');
let MovieService = class MovieService {
    constructor(http) {
        this.http = http;
    }
    getMovies() {
        return this.http.get('http://localhost:8080/project1/api/movies')
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    getMovieById(id) {
        return this.http.get(`http://localhost:8080/project1/api/movies/${id}`)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    getCommentsById(id) {
        return this.http.get(`http://localhost:8080/project1/api/comment/${id}`)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    createMovie(movie) {
        let headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        let options = new http_1.RequestOptions({ headers: headers });
        console.log(movie);
        console.log(options);
        return this.http.post('localhost:8080/project1/api/admin/createmovie', JSON.stringify({ username: "username", password: "password" }), options)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    updateMovie(movie) {
        let headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        let options = new http_1.RequestOptions({ headers: headers });
        return this.http.put(`localhost:8080/project1/api/admin/updatemovie`, movie, options)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    DeleteMovie(id) {
        let headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        let options = new http_1.RequestOptions({ headers: headers });
        return this.http.delete(`http://localhost:8080/project1/api/admin/deletemovie/$(id)`, options)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    getTopRatedMovies() {
        return this.http.get('http://localhost:8080/project1/api/movies/toprated')
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    getTopRatedTv() {
        return this.http.get('http://localhost:8080/project1/api/tv/toprated')
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    postcomments(comments) {
        let headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        let options = new http_1.RequestOptions({ headers: headers });
        return this.http.post('localhost:8080/project1/api/admin/comment', comments, options)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    getratingsById(id) {
        return this.http.get(`http://localhost:8080/project1/api/rating/${id}`)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    postrating(rating) {
        let headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        let options = new http_1.RequestOptions({ headers: headers });
        return this.http.post('localhost:8080/project1/api/admin/rating', rating, options)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
    getfilters(type, genre, year, sortby) {
        let link = "http://localhost:8080/project1/api/filter?";
        let array = [];
        if (type != null) {
            array.push("type=" + type);
        }
        if (year != null) {
            array.push("year=" + year);
        }
        if (genre != null) {
            array.push("genre=" + genre);
        }
        if (sortby != null) {
            array.push("sort=" + sortby);
        }
        link += array.join("&");
        console.log(link);
        return this.http.get(link)
            .map(response => response.json())
            .catch(error => Observable_1.Observable.throw(error.statusText));
    }
};
MovieService = __decorate([
    core_1.Injectable(), 
    __metadata('design:paramtypes', [http_1.Http])
], MovieService);
exports.MovieService = MovieService;
//# sourceMappingURL=movie.service.js.map