package com.project.JobApp.review;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyid}")
public class reviewcontroller {

    @Autowired
    private reviewservice reviewservice;

    @GetMapping("/reviews")
    public ResponseEntity<List<review>> getallreviews(@PathVariable Long companyid){
        return new ResponseEntity<>(reviewservice.getallreviews(companyid), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addreview(@PathVariable Long companyid,@RequestBody review review){
        boolean flag=reviewservice.addreview(companyid, review);
        if(flag)return new ResponseEntity<>("added successfully",HttpStatus.OK);
        return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/reviews/{reviewid}")
    public ResponseEntity<review> getreview(@PathVariable Long companyid,@PathVariable Long reviewid){
        review r=reviewservice.getreview(companyid,reviewid);
        if(r!=null)return new ResponseEntity<>(r,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewid}")
    public ResponseEntity<String> updatereview(@PathVariable Long companyid,@PathVariable Long reviewid,@RequestBody review review){
        boolean flag=reviewservice.updatereview(companyid, reviewid, review);
        if(flag)return new ResponseEntity<>("updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewid}")
    public ResponseEntity<String> deletereview(@PathVariable Long companyid,@PathVariable Long reviewid){
        boolean flag=reviewservice.deletereview(companyid, reviewid);
        if(flag)return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("id(s) not found",HttpStatus.NOT_FOUND);
    }

}
