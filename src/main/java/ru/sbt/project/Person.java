package ru.sbt.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Person {

    private static final Logger log = LogManager.getLogger(Person.class);

    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (person.man == this.man) {
            log.info("Spouse of the same sex");
            return false;
        }
        if (person == this.spouse) {
            log.info("Person is already married");
            return false;
        }
        this.divorce();
        person.divorce();

        this.spouse = person;
        person.spouse = this;
        log.info("Person has married");
        return true;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse == null) {
            log.info("Person is not married");
            return false;
        }
        this.spouse.spouse = null;
        this.spouse = null;
        log.info("Person divorced");
        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "man=" + man +
                ", name='" + name + '\'' +
                ", spouse=" + (spouse != null) +
                '}';
    }
}