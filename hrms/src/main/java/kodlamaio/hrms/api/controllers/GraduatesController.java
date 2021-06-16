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
import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Graduate;

@RestController
@RequestMapping("api/graduates")
@CrossOrigin
public class GraduatesController {
    private GraduateService graduateService;

    @Autowired
    public GraduatesController(GraduateService graduateService) {
        this.graduateService = graduateService;
    }

    @GetMapping("/getall")
    @ApiOperation("Get All Graduate")
    DataResult<List<Graduate>> getAll() {
        return this.graduateService.getAll();

    }

    @PostMapping("/add")
    @ApiOperation("Add Graduate")
    public Result add(@Valid @RequestBody Graduate graduate) {

        return this.graduateService.add(graduate);

    }
}