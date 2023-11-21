package com.datawisher.misc.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupExample {
    public static void main(String[] args) {
        // Sample data
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", 25));
        persons.add(new Person("Jane", "Smith", 30));
        persons.add(new Person("John", "Doe", 35));
        persons.add(new Person("Jane", "Doe", 40));

        // Grouping by first name and last name
        Map<String, Map<String, List<Person>>> groupedData = persons.stream()
                .collect(Collectors.groupingBy(Person::getFirstName,
                        Collectors.groupingBy(Person::getLastName)));

        // Printing the grouped data
        for (Map.Entry<String, Map<String, List<Person>>> entry : groupedData.entrySet()) {
            String firstName = entry.getKey();
            Map<String, List<Person>> lastNameMap = entry.getValue();
            System.out.println("First Name: " + firstName);
            for (Map.Entry<String, List<Person>> lastNameEntry : lastNameMap.entrySet()) {
                String lastName = lastNameEntry.getKey();
                List<Person> personList = lastNameEntry.getValue();
                System.out.println("Last Name: " + lastName);
                for (Person person : personList) {
                    System.out.println(person);
                }
            }
        }
    }

    static class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
