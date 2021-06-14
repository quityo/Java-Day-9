package kodlamaio.hrms.api.controllers;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.entities.concretes.Image;
@RestController
@RequestMapping("/api/images")
@CrossOrigin

public class ImagesController {

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping(value="/upload")
	public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int userId) throws IOException {
		Image image = new Image();
		User user = new User();
		user.setId(userId);
		image.setUser(user);
		
		return ResponseEntity.ok(this.imageService.add(file, image));
	}
	
    @GetMapping("/getById")
    public ResponseEntity<?> getById(int id) throws IOException{
        return ResponseEntity.ok(this.imageService.getById(id));
    }
    
    @GetMapping("/getByUserId")
    public ResponseEntity<?> getByUserId(int userId){
        return ResponseEntity.ok(this.imageService.getByUserId(userId));
    }
	
}