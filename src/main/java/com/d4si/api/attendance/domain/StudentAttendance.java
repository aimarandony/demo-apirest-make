package com.d4si.api.attendance.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STUDENTS_ATTENDANCE")
@Data
public class StudentAttendance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_activity")
    private Activity activity;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    @Column(name = "arrival_time")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Column(name = "realized_time")
    @Temporal(TemporalType.TIME)
    private Date realizedTime;
    private String note;
    private Boolean state;

    @PrePersist
    public void prePersist(){
        state = true;
        Long difference = arrivalTime.getTime() - departureTime.getTime();
        realizedTime = new Date(difference);

        System.out.println("\n\uD83D\uDCCC ENTRADA TIME >> " + arrivalTime.getTime());
        System.out.println("\uD83D\uDCCC ENTRADA DATE >> " + arrivalTime + "\n");

        System.out.println("\uD83D\uDCCC SALIDA TIME >> " + departureTime.getTime());
        System.out.println("\uD83D\uDCCC SALIDA DATE >> " + departureTime + "\n");

        System.out.println("\uD83D\uDCCC DIFERENCIA >> " + difference + "\n");

        System.out.println("\uD83D\uDCCC TOTAL TIME >> " + realizedTime.getTime());
        System.out.println("\uD83D\uDCCC TOTAL DATE >> " + realizedTime + "\n");;
    }
}
