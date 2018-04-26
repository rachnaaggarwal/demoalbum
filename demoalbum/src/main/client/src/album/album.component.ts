import { Component } from '@angular/core';

import { AlbumService } from './album.service';

@Component({
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent
{
  title = 'Demo Album';
  photos;
  
  constructor(private albumService: AlbumService) {}

  ngOnInit()
  {
	  //TODO Need to define the logic for handling x number of photos
      this.photos = this.albumService.getPhotos(1, 5);
  }

}