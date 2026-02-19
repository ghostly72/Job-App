package com.project.JobApp.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.JobApp.job.job;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    //The mappedBy attribute in Spring Boot (JPA/Hibernate) is used to specify that a relationship is bidirectional and that the current entity is the inverse (non-owning) side.
    //This means the other entity (the owning side) is responsible for managing the foreign key column(s) in the database.
    // Using mappedBy prevents JPA from creating a redundant, separate join table or a duplicate foreign key column in the current entity's table.
    @OneToMany(mappedBy = "cpy")//cpy is the one defined in jobs clas
    @JsonIgnore
    private List<job> jobs;

    //add list of reviews


}
