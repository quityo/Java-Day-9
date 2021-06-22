package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobAdverts")
@CrossOrigin
public class JobAdvertsController {
	
		private JobAdvertService jobAdvertService;

		@Autowired 
		public JobAdvertsController(JobAdvertService jobAdvertService) {
			super();
			this.jobAdvertService = jobAdvertService;
		}
		
		
		@GetMapping("/getall")
	    DataResult<List<JobAdvert>> getAll() {
	        return this.jobAdvertService.getAll();
	    }

		@GetMapping("/getbyisconfirm")
		public DataResult<List<JobAdvert>> getByIsActive(@RequestParam boolean isConfirm) {
			return this.jobAdvertService.getByIsConfirm(isConfirm);
		}

		@GetMapping("/getbyisconfirmandisactive")
		public DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(@RequestParam boolean isConfirm,
				@RequestParam boolean isActive) {
			return this.jobAdvertService.getByIsConfirmAndIsActive(isConfirm, isActive);
		}

		@GetMapping("/sortbyreleasedate")
		public DataResult<List<JobAdvert>> sortByReleaseDate() {
			return this.jobAdvertService.sortByReleaseDate();
		}

		@GetMapping("/getbycompanyname")
		public DataResult<List<JobAdvert>> getByCompanyName(@RequestParam String companyName) {
			return this.jobAdvertService.getByCompanyName(companyName);
		}

		@PostMapping("/add")
		public Result add(@Valid @RequestBody JobAdvertDto jobPostingDto) {
			return this.jobAdvertService.add(jobPostingDto);
		}

		@PostMapping("/updateisactive")
		public Result updateIsActive(@RequestParam boolean isActive, @RequestParam int userId,
				@RequestParam int id) {
			return this.jobAdvertService.updateIsActive(isActive, userId, id);
		}

		@PostMapping("/updateisconfirm")
		public Result updateIsConfirm(@RequestParam boolean isConfirm, @RequestParam int id) {
			return this.jobAdvertService.updateIsConfirm(isConfirm, id);
		}

		@GetMapping("/getbyjobpostingid")
		public DataResult<JobAdvert> getByJobPostingId(@RequestParam int id) {
			return this.jobAdvertService.getById(id);
		}
	}