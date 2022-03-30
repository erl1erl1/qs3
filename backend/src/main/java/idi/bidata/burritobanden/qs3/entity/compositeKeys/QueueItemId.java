package idi.bidata.burritobanden.qs3.entity.compositeKeys;


import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class QueueItemId implements Serializable {
    @Getter @Setter
    private Long queueId;
    @Getter @Setter
    private Long personId;
}
