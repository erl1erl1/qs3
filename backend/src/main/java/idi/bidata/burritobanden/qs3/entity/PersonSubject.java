package idi.bidata.burritobanden.qs3.entity;


import idi.bidata.burritobanden.qs3.entity.compositeKeys.PersonSubjectId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "person_subject")
@IdClass(PersonSubjectId.class)
public class PersonSubject {
    @Id
    private Long personId;
    @Id
    private Long subjectId;
}
