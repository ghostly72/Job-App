package com.project.JobApp.job.impl;

import com.project.JobApp.job.job;
import com.project.JobApp.job.jobrepo;
import com.project.JobApp.job.jobservice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class jobserviceimpl implements jobservice {
//    List<job> jobs=new ArrayList<>();
    jobrepo jobrepo;

    public jobserviceimpl(jobrepo jobrepo) {
        this.jobrepo = jobrepo;
    }

    @Override
    public List<job> findall() {
        return jobrepo.findAll();
    }

    @Override
    public void createjob(job job) {
        jobrepo.save(job);
    }

    @Override
    public job getjobbyid(Long id) {
        return jobrepo.findById(id).orElse(null);
    }

    @Override
    public boolean deletejobbyid(Long id) {
        try{
            jobrepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatejobbyid(Long id, job updatedjob) {
        Optional<job> jobOptional=jobrepo.findById(id);

//        if(){
            if(jobOptional.isPresent()){
                job j=jobOptional.get();
                j.setDescription(updatedjob.getDescription());
                j.setLocation(updatedjob.getLocation());
                j.setMaxsalary(updatedjob.getMaxsalary());
                j.setMinsalary(updatedjob.getMinsalary());
                j.setTitle(updatedjob.getTitle());
                jobrepo.save(j);
                return true;
            }
//        }
        return false;
    }
}
