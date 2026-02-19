package com.project.JobApp.job;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class jobcontroller {
    jobservice jobservice;
    private Long nextid;

    public jobcontroller(jobservice jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<job>> findall(){
        return ResponseEntity.ok(jobservice.findall());
    }

    @PostMapping
    public ResponseEntity<String> createjob(@RequestBody job j){
        j.setId(nextid++);
        jobservice.createjob(j);
        return new ResponseEntity<>("new job created successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<job> getjobbyid(@PathVariable Long id){
        job j=jobservice.getjobbyid(id);
        if(j!=null)return new ResponseEntity<>(j, HttpStatus.OK);
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletejobbyid(@PathVariable Long id){
        boolean j=jobservice.deletejobbyid(id);
        if(j)return new ResponseEntity<String>("job deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatejobbyid(@PathVariable Long id,@RequestBody job updatedjob){
        boolean flag=jobservice.updatejobbyid(id,updatedjob);
        if(flag)return new ResponseEntity<>("job updated successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
