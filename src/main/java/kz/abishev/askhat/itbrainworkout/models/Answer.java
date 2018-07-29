package kz.abishev.askhat.itbrainworkout.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @org.hibernate.annotations.Type(type = "text")
    private String body;
    @ManyToOne
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "QUESTION_ID_FK"))
    private Question question;
    @ManyToOne
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "TYPE_ID_FK"))
    private Type type;
}
