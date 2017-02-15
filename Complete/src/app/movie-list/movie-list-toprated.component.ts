import {Component} from '@angular/core';
import {MovieService} from '../movie-service/movie.service';

@Component({
    templateUrl: '/movie-list.component.html'
})
export class MovieListTopRatedComponent {

    movieList: any = [];

    constructor(private movieService: MovieService) {

        movieService.getTopRatedMovies()
            .subscribe(
                movies => this.movieList = movies,
                error => console.log(error)
            );
    }

}