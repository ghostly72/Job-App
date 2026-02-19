package com.project.JobApp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class companycontroller {
    @Autowired
    private companyservice companyservice;

    @GetMapping()
    public ResponseEntity<List<company>> getallcompany(){
        return new ResponseEntity<>(companyservice.getallcompanies(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatecompany(@PathVariable Long id,@RequestBody company company){
        companyservice.updatecompany(company,id);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }

    @PostMapping
    public void createcompany(@RequestBody company company){
        companyservice.createcompany(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable Long id){
        if(companyservice.deletebyid(id))return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<company> getcompanybyid(@PathVariable Long id){
        company c=companyservice.getcomapnybyid(id);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
