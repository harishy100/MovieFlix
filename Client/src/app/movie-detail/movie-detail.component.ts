import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {MovieService} from '../movie-service/movie.service';

@Component({
    templateUrl: '/movie-detail.component.html'
})
export class MovieDetailComponent {

    movie: any = {};commentsList :any={};comment :any={}; value :any;rating :any; value1:any;

    constructor(private route: ActivatedRoute, private movieService: MovieService) {
        this.route.params.subscribe(
            params => {
                movieService.getMovieById(params['id'])
                    .subscribe(
                        movie => this.movie = movie,
                        error => console.log(error),

                    );
            }
            );
    }
    imdblink()
    {
        let imdblink :string= "";
        console.log(this.movie.director);
        console.log(this.movie);
        imdblink = "http://www.imdb.com/title/" + this.movie.imdbId;
        window.location.href=imdblink;
    }
    viewcomments(){
        this.movieService.getCommentsById(this.movie.id)
            .subscribe(
                comments => this.commentsList = comments,
                error => console.log(error)
            );
    }
    postcomment(){
        this.comment.movie=this.movie;
        this.comment.comment= this.value;
        this.movieService.postcomments(this.comment)
            .subscribe(
                comments => this.commentsList = comments,
                error => console.log(error)
            );
    }
    userrating(){
        this.movieService.getratingsById(this.movie.id)
            .subscribe(
                comments => this.rating = comments,
                error => console.log(error)
            );
    }
    postrating(){
        this.comment.movie=this.movie;
        this.comment.comment= this.value1;
        this.movieService.postrating(this.comment)
            .subscribe(
                comments => this.rating = comments,
                error => console.log(error)
            );
    }
}

