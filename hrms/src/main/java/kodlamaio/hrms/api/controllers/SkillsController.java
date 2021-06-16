package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDto;

@RestController
@RequestMapping("/api/skills")
@Api("Skill api Documentation")
@CrossOrigin

public class SkillsController {
	private SkillService skillService;
	
	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	};
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody SkillDto skill){
		return this.skillService.add(skill);
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	
}