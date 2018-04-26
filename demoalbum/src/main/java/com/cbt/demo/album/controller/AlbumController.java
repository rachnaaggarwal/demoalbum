package com.cbt.demo.album.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cbt.demo.album.dto.Photo;

/**
 * <p>Title: AlbumController</p>
 * <p>Description: Rest Controller for Album Service.</p>
 *
 * @author Rachna Aggarwal
 * @version 1.0
 */
@RestController
public class AlbumController
{
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String URL = "https://5ad8d1c9dc1baa0014c60c51.mockapi.io/api/br/v1/magic/";
	private static final int START_IDX = 1;
	private static final int PAGE_SIZE = 10;
	
	@RequestMapping("api/photos")
	public List<Photo> getPhotos(@RequestParam int startIdx, @RequestParam int endIdx)
	{
		List<Photo> photoList = new ArrayList<>();
		
		if(startIdx <= 0)
			startIdx = START_IDX;
		
		if(endIdx <= 0)
			endIdx = PAGE_SIZE;

		for(int idx = startIdx; idx <= endIdx; idx++)
		{
			try {
				Photo photo = restTemplate.getForObject(URL + idx, Photo.class, new HashMap<>());
				
				photoList.add(photo);
			}
			catch (HttpClientErrorException e)
			{
				if(HttpStatus.NOT_FOUND.equals(e.getStatusCode()))
				{
					// Ignore as Id does not exist
				}
				else
				{
					throw e;
				}
			}
		}
		
		return photoList;
	}
	
}