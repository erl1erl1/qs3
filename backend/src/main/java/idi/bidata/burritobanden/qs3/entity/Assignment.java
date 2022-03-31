package idi.bidata.burritobanden.qs3.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "assignment")
public class Assignment {
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
}
