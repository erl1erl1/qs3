package idi.bidata.burritobanden.qs3.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;

    @ManyToMany
    @JoinTable(
            name = "person_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> enrolledStudents = new HashSet<>();
    private int assignments;



    public void enrollStudent(Person person){
        enrolledStudents.add(person);
    }

    public Long getSubjectId() {
        return subjectId;
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

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setAssignments(int assignments) {
        this.assignments = assignments;
    }
}
