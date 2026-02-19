package com.project.JobApp.job;

import com.project.JobApp.company.company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //default name of the table would be class name. to customize it use @table(name="table_name")
public class job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minsalary;
    private String maxsalary;
    private String location;

    @ManyToOne
    private company cpy;

    public job(String description, String title, String minsalary, String maxsalary, String location, long id) {
        this.description = description;
        this.title = title;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.location = location;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
