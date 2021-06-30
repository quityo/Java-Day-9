package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

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

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvsController {

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody Cv cv) {
		return this.cvService.add(cv);
	}

	

	@GetMapping("/getall")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}
	
	@PostMapping("/uploadimage")
	public ResponseEntity<?> uploadPhoto(@RequestParam(name = "id") Integer cvId,
			@RequestBody MultipartFile file) throws IOException {
		return ResponseEntity.ok(this.cvService.uploadCvPhoto(cvId, file));
	}
	
}