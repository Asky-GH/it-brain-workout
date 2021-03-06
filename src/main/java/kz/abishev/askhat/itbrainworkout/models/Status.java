package kz.abishev.askhat.itbrainworkout.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    private byte id;
    @Column(nullable = false, length = 10)
    private String title;
}
