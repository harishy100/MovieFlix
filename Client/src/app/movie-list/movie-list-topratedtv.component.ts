import {Component} from '@angular/core';
import {MovieService} from '../movie-service/movie.service';

@Component({
    templateUrl: '/movie-list.component.html'
})
export class MovieListTopRatedTvComponent {

    movieList: any = [];

    constructor(private movieService: MovieService) {

        movieService.getTopRatedTv()
            .subscribe(
                movies => this.movieList = movies,
                error => console.log(error)
            );
    }

}