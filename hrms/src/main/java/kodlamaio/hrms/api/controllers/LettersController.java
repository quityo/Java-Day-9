package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Letter;

@RestController
@RequestMapping("/api/letters")
@CrossOrigin
public class LettersController {

	private LetterService letterService;

	@Autowired
	public LettersController(LetterService letterService) {
		super();
		this.letterService = letterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Letter coverLetterForCV){
		return this.letterService.add(coverLetterForCV);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Letter coverLetterForCV){
		return this.letterService.update(coverLetterForCV);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.letterService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Letter> getById(@RequestParam("id") int id){
		return this.letterService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Letter>> getAll(){
		return this.letterService.getAll();
	}
	
}