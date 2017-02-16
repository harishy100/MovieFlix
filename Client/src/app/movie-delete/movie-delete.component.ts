import {Component} from '@angular/core';
import {MovieService} from '../movie-service/movie.service';

@Component({
    templateUrl: '/movie-delete.component.html'
})
export class MovieDeleteComponent {

    movieList: any = [];movie:any; value : any;

    constructor(private movieService: MovieService) {

        movieService.getMovies()
            .subscribe(
                movies => this.movieList = movies,
                error => console.log(error)
            );
    }
    submit(){
        this.movieService.DeleteMovie(this.value) .subscribe(
            movies => this.movie = movies,
            error => console.log(error)
        );

    }

}
