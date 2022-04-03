package idi.bidata.burritobanden.qs3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The Subject class represents a subject. Lombok is not used here either, also because of the many-to-many relation.
 * We avoid an infinite loop when rendering subjects by not including the enrolled students in the JSON-object.
 * This is done by the @JsonIgnore.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "subject_id")
    private String subjectCode;
    private String subjectName;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private Set<Person> enrolledStudents = new HashSet<>();
    private int assignments;



    public void enrollStudent(Person person){
        enrolledStudents.add(person);
    }

    public void enrollPerson(Person person) {enrolledStudents.add(person);}

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Set<Person> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getAssignments() {
        return assignments;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setAssignments(int assignments) {
        this.assignments = assignments;
    }
}
