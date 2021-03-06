package kz.abishev.askhat.itbrainworkout.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @org.hibernate.annotations.Type(type = "text")
    private String body;
    @ManyToOne
    @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "SUBJECT_ID_FK"))
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "status_id", foreignKey = @ForeignKey(name = "STATUS_ID_FK"))
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Answer> answers = new HashSet<>();
}
