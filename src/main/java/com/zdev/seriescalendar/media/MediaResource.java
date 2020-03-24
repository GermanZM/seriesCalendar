package com.zdev.seriescalendar.media;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MediaResource {
	
	public static ResponseEntity<Resource> getPhoto(String photoName, String path) {
		Path url = Paths.get(path).resolve(photoName).toAbsolutePath();
		Resource img = null;
		HttpHeaders header = null;
		try {
			img = new UrlResource(url.toUri());
			
			if(!img.exists() && !img.isReadable()) {
				url = Paths.get("src/main/resources/images/").resolve("default.png").toAbsolutePath();
				img = new UrlResource(url.toUri());
				header = new HttpHeaders();
				header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getFilename() + "\"");
				return new ResponseEntity<Resource>(img,header,HttpStatus.OK);
			}
			
			header = new HttpHeaders();
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getFilename() + "\"");

		} catch (MalformedURLException e) {
			return new ResponseEntity<Resource>(img,header,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Resource>(img,header, HttpStatus.OK);
	}

}
