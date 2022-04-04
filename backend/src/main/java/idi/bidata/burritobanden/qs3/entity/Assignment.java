package idi.bidata.burritobanden.qs3.entity;

import javax.persistence.*;
import idi.bidata.burritobanden.qs3.model.compositeKeys.AssignmentKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

/**
 * The Assignment entity represents an assignment, "øving", in the backend. Lombok tags are used for constructor,
 * getters and setters. This class has a composite key between person ID and subject code.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ASSIGNMENTS")
@IdClass(AssignmentKey.class)
public class Assignment implements Serializable {

    /*
    Primary key
     */
    @Id
    @Column(name = "person_id")
    private Long personId;

    /*
    Primary key.
     */
    @Id
    @Column(name = "subject_code")
    private String subjectCode;

    @ElementCollection
    private List<Boolean> assignments;

}