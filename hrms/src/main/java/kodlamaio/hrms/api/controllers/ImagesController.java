package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping(value="/upload")
	public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int jobSeekerid) throws IOException {
		Image image = new Image();
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setId(jobSeekerid);
		image.setJobSeeker(jobSeeker);
		
		return ResponseEntity.ok(this.imageService.add(file, image));
	}
	
    @GetMapping("/getById")
    public ResponseEntity<?> getById(int id) throws IOException{
        return ResponseEntity.ok(this.imageService.getById(id));
    }
    
    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(int id){
        return ResponseEntity.ok(this.imageService.getByJobSeekerId(id));
    }
	
}