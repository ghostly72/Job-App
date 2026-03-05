package com.project.JobApp.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.JobApp.company.company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;

    @ManyToOne
    @JsonIgnore
    private company cm;


}
