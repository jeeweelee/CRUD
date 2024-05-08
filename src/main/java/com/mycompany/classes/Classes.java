package com.mycompany.classes;

import com.mycompany.dean.Dean;
import com.mycompany.professor.Professor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "classes")
public class Classes {
    private static final String DMBS = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, name = "class_name")
    private String class_name;

    @Column(length = 100, nullable = false, name = "class_location")
    private String class_location;

    @Column(length = 5, nullable = false, name = "num_of_students")
    private Integer num_of_students;

    @Column(length = 25, nullable = true, name = "subject")
    private String subject;

    @Column(length = 150, nullable = false, name = "class_description")
    private String class_description;

    @Column(length = 5, nullable = false, name = "class_duration")
    private Integer class_duration;

    @Column(length = 25, nullable = false, name = "class_grade")
    private String class_grade;

    @OneToMany(mappedBy = "classes")
    private Set<Professor> professors;

    public void fixSubject(){
        if(this.subject.toLowerCase().equals("dbms")){
            this.subject = "DBMS";
        }else if (this.subject.toLowerCase().equals("maths")){
            this.subject = "MATHS";
        }else if (this.subject.toLowerCase().equals("python")){
            this.subject = "PYTHON";
        }
    }

    public void setDescription(){
        System.out.println(this.subject);
        if (this.subject.equals("DBMS")){
            this.class_description = "This subject will help you Learn about databases";   
        }else if (this.subject.equals("PYTHON")){
            this.class_description = "This subject will help you to get familiar with coding";
        }else if (this.subject.equals("MATHS")){
            this.class_description ="This subjects will teach you all the needed calculations ";
        }else{
            this.class_description = " No information";
        }
    }
     
}
