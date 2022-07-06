package ir.mapsa.student;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "family")
    private String family;

    @NotNull
    @NotBlank
    @Column(name = "nationalCode")
    private String nationalCode;

    @NotNull
    @NotBlank
    @Column(name = "picture")
    private String picture;

    @NotNull
    @NotBlank
    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate")
    private Date birthDate;

    @Transient
    private String sample1;

    @Transient
    private String sample2;
}
