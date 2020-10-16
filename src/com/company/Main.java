package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        NameComparator nameComparator = new NameComparator();
        AgeComparator ageComparator = new AgeComparator();

        Comparator<Person> comparator = nameComparator.thenComparing(ageComparator);
        TreeSet<Person> people = new TreeSet<>(comparator);
        people.add(new Person("Mike", 45));
        people.add(new Person("Petya", 33));
        people.add(new Person("Mirlan",26));
        people.add(new Person("Alina", 18));
        people.add(new Person("Shariman", 61));
        people.add(new Person("AWA", 65));
        people.add(new Person("Soke", 61));
        people.add(new Person("Azamat", 28));
        people.add(new Person("Azamat", 27));
        people.add(new Person("Azamat", 27));
        people.add(new Person("Azamat", 27));

        System.out.println(people.size());

        printCollection(people);

        Person p = people.first();
        System.out.println("First: " + p.getName()+" "+p.getAge());

        p = people.last();
        System.out.println("Last: "+p.getName()+" "+p.getAge());

        Person example = new Person("Mike", 50);
        people.add(example);

        printCollection(people);

        System.out.println("Headset");
        printCollection(people.headSet(example));

        System.out.println("Tailset");
        printCollection(people.tailSet(example));

    }

    public static void printCollection (Set<Person> people){
        System.out.println("__________________");
        Iterator<Person> iter = people.iterator();
        while (iter.hasNext()){
            Person p = iter.next();
            System.out.println(p.getName() + " age = " + p.getAge());
        }
    }
}
