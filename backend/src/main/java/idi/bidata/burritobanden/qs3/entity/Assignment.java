package idi.bidata.burritobanden.qs3.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Assignment entity represents an assignment, "øving", in the backend. Lombok tags are used for constructor,
 * getters and setters.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "assignment")
public class Assignment {
    // Generate id for the object and define it as the primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assignment_id", nullable = false)
    private Long assignmentId;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "subject_id", nullable = false)
    private Long subjectId;

    @Column(name = "assignment_num", nullable = false)
    private int assignmentNum;

    private boolean approved;
}
