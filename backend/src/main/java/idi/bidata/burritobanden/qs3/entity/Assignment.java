package idi.bidata.burritobanden.qs3.entity;

import javax.persistence.*;

import java.util.List;
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
    private long assignmentId;
    private long personId;
    private long subjectId;
    private int assignmentNum;
}
