package com.mycompany.department;

import com.mycompany.professor.Professor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, name = "department_name")
    private String department_name;

    @Column(length = 100, nullable = false, name = "department_location")
    private String department_location;

    @OneToMany(mappedBy = "department")
    private Set<Professor> professors;

}
