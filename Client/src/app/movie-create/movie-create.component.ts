import {Component} from '@angular/core';
import {MovieService} from '../movie-service/movie.service';
import {UserService} from "../user-service/user.service";


@Component({
    templateUrl: '/movie-create.component.html'
})


export class MovieCreateComponent {

   movie : any={};mve:any = {};
     constructor(private movieservice: MovieService) {

    }
    onsubmit(){
         //To format the input object in the required form for the server.
         let array : string;let i=0;let array1 : string;
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

        this.movieservice.createMovie(this.movie).subscribe(
            movies => this.movie = movies,
            error => console.log(error)
        );

    }

}