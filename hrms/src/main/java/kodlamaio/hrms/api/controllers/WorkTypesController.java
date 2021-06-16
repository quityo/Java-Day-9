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
import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkType;

@CrossOrigin
@RestController
@RequestMapping("/api/worktypes")
public class WorkTypesController {
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		this.workTypeService = workTypeService;
	}
	
	@PostMapping("/add")
	@ApiOperation("Add Work Type")
	DataResult<WorkType> add(@RequestBody WorkType workType){
		return workTypeService.add(workType);
	}
	@GetMapping("/getbyid")
    @ApiOperation("GetById WayType")
    DataResult<WorkType> getById(@RequestParam("id") int id) {
        return workTypeService.getById(id);

    }

    @GetMapping("/getall")
    @ApiOperation("GetAll WorkType")
    DataResult<List<WorkType>> getAll() {
        return workTypeService.getAll();

    }
}
