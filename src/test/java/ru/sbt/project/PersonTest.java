package ru.sbt.project;

import org.junit.Assert;
import org.junit.Test;


public class PersonTest {

    @Test
    public void marry() {
        Person p1 = new Person(false, "Anna");
        Person p2 = new Person(true, "Max");
        Assert.assertTrue(p1.marry(p2));

        Person p3 = new Person(false, "Inna");
        Assert.assertFalse(p3.marry(p1));

        Person p4 = new Person(true, "Alex");
        Assert.assertFalse(p4.marry(p2));

        Person p5 = new Person(true, "Petr");
        Assert.assertTrue(p1.marry(p5));
    }

    @Test
    public void divorce() {
        Person p1 = new Person(false, "Anna");
        Person p2 = new Person(true, "Max");
        Assert.assertTrue(p1.marry(p2));

        Assert.assertTrue(p1.divorce());
        Assert.assertFalse(p1.divorce());
        Assert.assertFalse(p2.divorce());
    }

}