package com.mycompany.student;

import com.mycompany.classes.Classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 45, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 45, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 45, nullable = false, name = "major")
    private String major;

    @Column(length = 5, nullable = false, name = "credit")
    private int credit;

    @Column(length = 45, nullable = false, name = "classification")
    private String classification;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName="id")
    private Classes classes;
    
    public void SetClassification(){
        if(this.credit <= 30){
            this.classification = "Freshman";
        }else if(this.credit > 30 && this.credit <= 60){
            this.classification = "Sophomore";
        }else if(this.credit > 60 && this.credit <= 90){
            this.classification = "Junior";
        }else if(this.credit > 90){
            this.classification = "Senior";
        }
        System.out.println("Classes: " + this.classes);
    }

}
