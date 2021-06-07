package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/employerRegister")
    public Result registerForEmployer(@RequestBody EmployerRegisterDto employer) {
        return authService.employerRegister(employer);
    }

    @PostMapping("/jobSeekerRegister")
    public Result registerForJobSeeker(@RequestBody JobSeekerRegisterDto jobSeeker){
        return authService.jobSeekerRegister(jobSeeker);
    }

}