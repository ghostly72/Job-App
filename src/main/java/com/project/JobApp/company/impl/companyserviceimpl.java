package com.project.JobApp.company.impl;

import com.project.JobApp.company.company;
import com.project.JobApp.company.companyrepo;
import com.project.JobApp.company.companyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class companyserviceimpl implements companyservice {

    @Autowired
    private companyrepo companyrepo;
    @Override
    public List<company> getallcompanies() {
        return companyrepo.findAll();
    }

    @Override
    public boolean updatecompany(company company, Long id) {
        Optional<company> companyOptional=companyrepo.findById(id);
        if(companyOptional.isPresent()){
            company c=companyOptional.get();
            c.setDescription(company.getDescription());
            c.setName(company.getName());
            c.setJobs(company.getJobs());
            companyrepo.save(c);
            return true;
        }
        return false;
    }

    @Override
    public void createcompany(company company) {
        companyrepo.save(company);
    }

    @Override
    public boolean deletebyid(Long id) {
        if(companyrepo.existsById(id)) {
            companyrepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public company getcomapnybyid(Long id) {
        return companyrepo.findById(id).orElse(null);
    }
}
