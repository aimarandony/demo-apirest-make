package com.d4si.api.attendance.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Activities")
@Data
public class Activity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String address;
    private String description;
    private Boolean state;

    @PrePersist
    public void prePersist(){
        createdAt = new Date();
        state = true;
    }
}