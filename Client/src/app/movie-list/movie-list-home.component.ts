import {Component} from '@angular/core';
import {MovieService} from '../movie-service/movie.service';

@Component({
    templateUrl: '/movie-list.component.html'
})
export class MovieListHomeComponent {

    type :any=[];movieList: any = [];years :any=[];genres:any=[];sortby:any=[];typevalue:string; i : number=0;y:number=2000;yearvalue :string;genrevalue:string;sortvalue:string;

    constructor(private movieService: MovieService) {

        while(this.i<10){
            this.years.push(this.y);
            (this.y)++;(this.i)++;
        }
        this.genres.push("Mystery");this.genres.push("thriller");
        this.sortby.push("imdbrating");this.sortby.push("imdbvotes");
        this.type.push("tv");this.type.push("Movie");


        movieService.getMovies()
            .subscribe(
                movies => this.movieList = movies,
                error => console.log(error)
            );

    }

    submitvalues(){
        this.movieService.getfilters(this.typevalue,this.genrevalue,this.yearvalue,this.sortvalue).subscribe(
            movie => this.movieList = movie,
            errors => console.log(errors)
        );
    }



}