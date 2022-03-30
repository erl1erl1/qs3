package idi.bidata.burritobanden.qs3.entity;

import idi.bidata.burritobanden.qs3.entity.compositeKeys.QueueItemId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "queue_item")
@IdClass(QueueItemId.class)
public class QueueItem {
    @Id
    private Long queueItemId;
    @Id
    private Long personId;
    private Date date;
    private Long assignmentId;
}
