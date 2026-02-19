package com.project.JobApp.company;

import java.util.List;

public interface companyservice {
    List<company> getallcompanies();

    boolean updatecompany(company company, Long id);

    void createcompany(company company);

    boolean deletebyid(Long id);
    company getcomapnybyid(Long id);
}
