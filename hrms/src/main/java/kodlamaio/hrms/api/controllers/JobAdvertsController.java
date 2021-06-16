package kodlamaio.hrms.api.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import kodlamaio.hrms.entities.dtos.JobAdvertRequestDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
	
		private JobAdvertService jobAdvertService;

		@Autowired 
		public JobAdvertsController(JobAdvertService jobAdvertService) {
			super();
			this.jobAdvertService = jobAdvertService;
		}
		@PostMapping("/addAd")
        @ApiOperation(value = "Add AD Method")
        ResponseEntity<?> add (@Valid @RequestBody JobAdvertRequestDto jobAdvert){
            return ResponseEntity.ok(this.jobAdvertService.addAd(jobAdvert));

        }
        @GetMapping("/getActive")
        @ApiOperation(value = "get Actv Method")
        DataResult<List<JobAdvertDto>> getActive () {
            return this.jobAdvertService.getActive();

        }
        @GetMapping("/getActiveandEmp")
        @ApiOperation(value = "get emp Method")
        DataResult<List<JobAdvertDto>> getEmpId ( @RequestParam int id){
            return this.jobAdvertService.getEmpId(id);

        }

        @GetMapping("/getActiveAndDate")
        @ApiOperation(value = "get emp Method")
        DataResult<List<JobAdvertDto>> getAdDate () {
            return this.jobAdvertService.getAdDate();

        }
        @PutMapping("/updateActive")
        @ApiOperation(value = "get emp Method")
        DataResult<JobAdvert> updateActive ( @RequestParam int id, @RequestParam boolean active){
            return this.jobAdvertService.updateActive(id, active);

        }

        @GetMapping("/getAdCustomDate")
        @ApiOperation(value = "get emp Method")
        DataResult<List<JobAdvertDto>> getAdCustomDate (@RequestParam Date date){
            return this.jobAdvertService.getAdCustomDate(date);

        }

    }