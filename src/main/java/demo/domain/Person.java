package demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * Created by Pedro on 26/06/2014.
 */
@Entity
class Person extends AbstractPersistable<Long> {
    private static final long serialVersionUID = 2669340231494998572L;

    private static final Logger logger = LoggerFactory.getLogger(Person.class);

    @Column
    private String firstName;
    @Column
    private String lastName;

    private Person() { }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @PrePersist
    public void onPrePersist() {
        logger.info("onPrePersist");
    }

    @PostPersist
    public void onPostPersist() {
        logger.info("onPostPersist");
    }

    @PreUpdate
    public void onPreUpdate() {
        logger.info("onPreUpdate");
    }

    @PostUpdate
    public void onPostUpdate() {
        logger.info("onPostUpdate");
    }

    @PreRemove
    public void onPreRemove() {
        logger.info("onPreRemove");
    }

    @PostRemove
    public void onPostRemove() {
        logger.info("onPostRemove");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
