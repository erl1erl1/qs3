package idi.bidata.burritobanden.qs3.entity;

import idi.bidata.burritobanden.qs3.entity.compositeKeys.QueueId;
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
    @Column(name = "person_id")
    private Long personId;
    @Id
    @Column(name = "subject_id")
    private Long subjectId;
    private Date date;
    private Long assignmentId;
    private String location;
}
