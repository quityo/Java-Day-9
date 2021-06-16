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

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EducationDto;

@RestController
@RequestMapping(value = "/api/education")
@CrossOrigin
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Education")
    DataResult<List<EducationDto>> getAll() {
        return this.educationService.getAll();

    }

    @PostMapping(value = "/add")
    @ApiOperation("Add Education")
    public Result add(@Valid @RequestBody EducationDto education) {

        return this.educationService.add(education);

    }

    @GetMapping("/getCvEducations")
    @ApiOperation("Get All Education")
    public DataResult<List<EducationDto>> findAllByCvIdOrderByEndAt(int cvId) {

        return this.educationService.findAllByCvIdOrderByEndAtDesc(cvId);
    }

}