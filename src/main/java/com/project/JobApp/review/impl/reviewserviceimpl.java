package com.project.JobApp.review.impl;

import com.project.JobApp.company.company;
import com.project.JobApp.company.companyrepo;
import com.project.JobApp.company.companyservice;
import com.project.JobApp.review.review;
import com.project.JobApp.review.reviewrepo;
import com.project.JobApp.review.reviewservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewserviceimpl implements reviewservice {

    @Autowired
    private reviewrepo reviewrepo;
    @Autowired
    private companyrepo companyrepo;

    @Autowired
    private companyservice companyservice;
    @Override
    public List<review> getallreviews(Long companyid) {
        List<review> list=reviewrepo.findByCm_Id(companyid);
        return list;
    }

    @Override
    public boolean addreview(Long companyid, review review) {
        company c=companyrepo.findById(companyid).orElse(null);
        if(c!=null){
            review.setCm(c);
            reviewrepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public review getreview(Long companyid, Long reviewid) {
        List<review> list=reviewrepo.findByCm_Id(companyid);
        for(review r:list){
            if(r.getId()==reviewid)return r;
        }
        return null;
    }

    @Override
    public boolean updatereview(Long companyid, Long reviewid, review review) {
        company c=companyrepo.findById(companyid).orElse(null);
        if(c!=null){
           review.setCm(c);
           review.setId(reviewid);
           return true;
        }
        return false;
    }

    @Override
    public boolean deletereview(Long companyid, Long reviewid) {
        company c=companyrepo.findById(companyid).orElse(null);
        if(c!=null){
            review r=reviewrepo.findById(reviewid).orElse(null);
            if(r!=null){
                company cpy=r.getCm();
                cpy.getList().remove(r);
                companyservice.updatecompany(c,companyid);
                reviewrepo.deleteById(reviewid);
                return true;
            }
        }
        return false;

    }
}
