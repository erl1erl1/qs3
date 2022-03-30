package idi.bidata.burritobanden.qs3.entity.compositeKeys;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PersonSubjectId implements Serializable {

    @Getter @Setter
    private Long personId;

    @Getter @Setter
    private Long subjectId;
}
