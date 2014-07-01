package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Pedro on 26/06/2014.
 */
public interface PersonRepository extends JpaRepository<Person, Long>, QueryDslPredicateExecutor<Person> {
}
