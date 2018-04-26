import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AlbumService
{
    constructor(private http: HttpClient) { }

    getPhotos(startIdx, endIdx)
    {
        var promise = this.http.get('/api/photos', {params: { startIdx: startIdx, endIdx: endIdx }})
            .toPromise()
            .then(res => {
                return res;
            })
            .catch(error => {
                console.error('An error occurred', error);
                return Promise.reject(error.message || error);
            });
            return promise;
    }

}