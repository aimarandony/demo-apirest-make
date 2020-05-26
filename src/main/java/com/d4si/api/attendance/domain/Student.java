package com.d4si.api.attendance.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STUDENTS")
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_district")
    private District district;
    private String name;
    private String lastname;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    private String gender;
    private String phone;
    private String mail;
    private Boolean state;

    @PrePersist
    public void prePersist(){
        state = true;
    }
}
