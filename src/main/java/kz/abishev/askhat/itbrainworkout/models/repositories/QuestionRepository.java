package kz.abishev.askhat.itbrainworkout.models.repositories;

import kz.abishev.askhat.itbrainworkout.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
