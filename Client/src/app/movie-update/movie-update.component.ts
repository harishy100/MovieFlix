import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {MovieService} from '../movie-service/movie.service';

@Component({
    templateUrl: '/movie-update.component.html'
})
export class MovieUpdateComponent {

    mve: any = {}; movie :any ={};id:any;

    constructor(private route: ActivatedRoute, private movieService: MovieService) {
        this.route.params.subscribe(
            params => {
                this.id=params['id'];
                movieService.getMovieById(params['id'])
                    .subscribe(
                        mve => this.mve = mve,
                        error => console.log(error)
                    );
            });
    }
    onsubmit(){
        //To format the input object in the required form for the server.
        let array : string;let i=0;let array1 : string;this.movie.id=this.id;
        array =this.movie.genres.split(',');array1=this.movie.actors.split(',');
        this.movie.genres = [];this.movie.actors=[];
        while(i<array.length){
            this.movie.genres.push({genrename : array[i]});
            i++;
        }
        i=0;
        while(i<array1.length){
            this.movie.actors.push({actor : array1[i]});
            i++;
        }

        this.movieService.updateMovie(this.movie);

    }
}