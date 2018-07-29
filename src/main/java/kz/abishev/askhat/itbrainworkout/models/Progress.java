package kz.abishev.askhat.itbrainworkout.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "progresses")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;
    @ManyToOne
    @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "SUBJECT_ID_FK"))
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name = "QUESTION_ID_FK"))
    private Question question;
    @ManyToOne
    @JoinColumn(name = "result_id", foreignKey = @ForeignKey(name = "RESULT_ID_FK"))
    private Result result;
}
