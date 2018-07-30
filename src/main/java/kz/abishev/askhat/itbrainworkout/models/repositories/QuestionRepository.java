package kz.abishev.askhat.itbrainworkout.models.repositories;

import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.models.Status;
import kz.abishev.askhat.itbrainworkout.models.Subject;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    Iterable<Question> findBySubjectAndStatus(Subject subject, Status status);
}
