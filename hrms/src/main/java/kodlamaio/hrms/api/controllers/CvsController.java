package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvsController {

    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Graduate")
    DataResult<List<CvDto>> getAll() {
        return this.cvService.getAll();

    }
    @GetMapping("/getallCandidateId")
    @ApiOperation("Get All Cv")
    DataResult<List<Cv>> getAllJobseekerId(@RequestParam int id) {
        return this.cvService.getAllJobseekerId(id);

    }

    @PostMapping("/add")
    @ApiOperation("Add Graduate")
    public Result add(@Valid @RequestBody Cv cv) {

        return this.cvService.add(cv);
    }

    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int cvId) {
        return this.cvService.saveImage(file, cvId);

    }
}