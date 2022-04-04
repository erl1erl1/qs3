package idi.bidata.burritobanden.qs3.model.compositeKeys;

import lombok.*;
import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentKey implements Serializable {

    @Getter @Setter
    private Long personId;

    @Getter @Setter
    private String subjectCode;
}
