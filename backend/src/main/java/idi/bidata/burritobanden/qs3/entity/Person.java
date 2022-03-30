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
@Table(name = "Person")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personid", nullable = false)
    private Long personId;
    private String name;
    private String role;
}
