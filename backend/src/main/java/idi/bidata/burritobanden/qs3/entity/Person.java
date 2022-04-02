package idi.bidata.burritobanden.qs3.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "person")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @ManyToMany
    @JoinTable(
            name = "person_subject",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_code")
    )
    private Set<Subject> subjects = new HashSet<>();

    private String name;
    private String username;
    private String password;
    private String role;

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public Long getPersonId() {
        return personId;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
