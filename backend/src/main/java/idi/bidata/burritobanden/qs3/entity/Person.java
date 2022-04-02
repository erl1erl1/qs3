package idi.bidata.burritobanden.qs3.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The Person entity represents a user. Class name User is not used because of JPA having its own User-class.
 * Lombok is not used in this class because of the many-to-many relationship with "person_subject".
 * @see idi.bidata.burritobanden.qs3.entity.Subject
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "person")
public class Person {
    // Generate id for the object and define it as the primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    // Many-to-many relation
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
