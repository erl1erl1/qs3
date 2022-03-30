package idi.bidata.burritobanden.qs3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "queue_id", nullable = false)
    private Long queueId;
    private Long subjectId;
}
