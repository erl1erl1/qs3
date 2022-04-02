package idi.bidata.burritobanden.qs3.entity;

import idi.bidata.burritobanden.qs3.model.compositeKeys.QueueId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "queue")
@IdClass(QueueId.class)
public class Queue {
    @Id
    @Column(name = "person_id", nullable = false)
    private Long personId;
    @Id
    @Column(name = "subject_code", nullable = false)
    private String subjectCode;
    private Date date;

    @Column(name = "assignment_id")
    private Long assignmentId;
    private String location;
    private String type;
    private boolean approved;
}
