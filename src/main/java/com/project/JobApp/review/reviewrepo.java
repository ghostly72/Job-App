package com.project.JobApp.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reviewrepo extends JpaRepository<review,Long> {
    List<review> findByCm_Id(Long companyid);
}
