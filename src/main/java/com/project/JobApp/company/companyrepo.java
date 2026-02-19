package com.project.JobApp.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface companyrepo extends JpaRepository<company, Long> {
}
