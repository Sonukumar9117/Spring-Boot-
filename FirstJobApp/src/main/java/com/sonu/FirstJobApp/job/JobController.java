package com.sonu.FirstJobApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>>findAll(){
        return  new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }


    @PostMapping("/jobs")
    public ResponseEntity<String> createjob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created Successfully", HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id){
        Job job=jobService.finJobById(id);
        if(job!=null)
          return new ResponseEntity<>(job,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    public  ResponseEntity<String> deleteJobById(@PathVariable Long id){
        if(jobService.deleteById( id))
              return new ResponseEntity<>("Deleted Successfull",HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
//    @RequestMapping(value ="/jobs/{id}",method =RequestMethod.PUT)
    public ResponseEntity<String>updateJob(@PathVariable Long id,
                                           @RequestBody Job updatedJob){
        boolean updated=jobService.updateJob(id,updatedJob);
        if(updated)
            return  new ResponseEntity<>("Job Updated",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
