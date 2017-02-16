import {Injectable} from '@angular/core';
import {Http, Response,Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class MovieService {
    constructor(private http: Http) {
    }

    getMovies(): Observable<any[]> {
        return this.http.get('http://localhost:8080/project1/api/movies')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    getMovieById(id: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/project1/api/movies/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getCommentsById(id: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/project1/api/comment/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    createMovie(movie: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        console.log(movie);console.log(options);
        return this.http.post('localhost:8080/project1/api/admin/createmovie', JSON.stringify({username:"username", password:"password"}), options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    updateMovie( movie: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.put(`localhost:8080/project1/api/admin/updatemovie`, movie, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    DeleteMovie(id:String ): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});

        return this.http.delete(`http://localhost:8080/project1/api/admin/deletemovie/$(id)`,options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getTopRatedMovies() : Observable<any[]>{
        return this.http.get('http://localhost:8080/project1/api/movies/toprated')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));

    }
    getTopRatedTv() : Observable<any[]>{
        return this.http.get('http://localhost:8080/project1/api/tv/toprated')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));

    }
    postcomments(comments: any): Observable<any[]> {

        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('localhost:8080/project1/api/admin/comment', comments, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getratingsById(id: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/project1/api/rating/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    postrating(rating: any): Observable<any[]> {

        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('localhost:8080/project1/api/admin/rating', rating, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
    getfilters(type: string,genre:string,year:string, sortby:string): Observable<any[]> {
        let link:string="http://localhost:8080/project1/api/filter?";
        let array :string[]=[];
        if(type!=null){
            array.push("type="+type);
        }
        if(year!=null){
            array.push("year="+year);
        }
        if(genre!=null){
            array.push("genre="+genre);
        }
        if(sortby!=null){
            array.push("sort="+sortby);
        }
        link+=array.join("&");
        console.log(link);
        return this.http.get(link)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
}

