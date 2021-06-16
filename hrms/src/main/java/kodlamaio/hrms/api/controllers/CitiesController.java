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

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("api/cities")
@CrossOrigin
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    @ApiOperation("Add City")
    DataResult<City> add(@RequestBody City city) {
        return cityService.add(city);

    }

    @GetMapping("/getbyid")
    @ApiOperation("GetById City")
    DataResult<City> getById(@RequestParam("id") int id) {
        return cityService.getById(id);

    }

    @GetMapping("/getall")
    @ApiOperation("GetAll City")
    DataResult<List<City>> getAll() {
        return cityService.getAll();

    }
}