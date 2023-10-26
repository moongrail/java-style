package org.example.early_math.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Bfs {
    public static void main(String[] args) {
        Person person = new Person("Alice", false);
        Person person1 = new Person("Bob", false);
        Person person2 = new Person("Ignat", false);
        Person person3 = new Person("Timur", false);
        Person person4 = new Person("Rustem", false);
        Person person5 = new Person("Valya", false);
        Person person6 = new Person("mango", true);
        Person person7 = new Person("Vol", true);
        Person person8 = new Person("Bol", true);

        person.getPersonDeque().add(person1);
        person.getPersonDeque().add(person2);
        person.getPersonDeque().add(person3);

        person3.getPersonDeque().add(person4);
        person3.getPersonDeque().add(person);
        person3.getPersonDeque().add(person5);
        person3.getPersonDeque().add(person6);

        person5.getPersonDeque().add(person7);
        person5.getPersonDeque().add(person8);

        System.out.println(graphSearch(person));
    }

    private static String graphSearch(Person person) {
        HashSet<Person> searchedSet = new HashSet<>();
        searchedSet.add(person);

        if (!person.getPersonDeque().isEmpty()) {
            LinkedList<Person> searchQue = new LinkedList<>(person.getPersonDeque());

            while (!searchQue.isEmpty()) {
                Person first = searchQue.pollFirst();
                searchedSet.add(first);

                if (first.isSeller()) {
                    return first.toString();
                } else {
                    if (!first.getPersonDeque().isEmpty()) {
                        // Было два варианта, добавлять всех в очередь и потом смотреть есть ли он в уже просмотренных
                        // людях, либо сразу проверять список у текущего, есть ли уже просмотренные и потом только
                        // добавлять в очередь.
                        while (!first.getPersonDeque().isEmpty()) {
                            Person personToAdd = first.getPersonDeque().pollFirst();

                            if (!searchedSet.contains(personToAdd)) {
                                searchQue.addLast(personToAdd);
                            }
                        }
                    }
                }
            }
        }

        return "Нет продавца";
    }

    private static class Person {
        private String name;
        private boolean isSeller;

        LinkedList<Person> personDeque = new LinkedList<>();

        public Person(String name, boolean isSeller) {
            this.name = name;
            this.isSeller = isSeller;
        }

        public LinkedList<Person> getPersonDeque() {
            return personDeque;
        }

        public void setPersonDeque(LinkedList<Person> personDeque) {
            this.personDeque = personDeque;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSeller() {
            return isSeller;
        }

        public void setSeller(boolean seller) {
            isSeller = seller;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", isSeller=" + isSeller +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return isSeller == person.isSeller && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, isSeller);
        }
    }
}

