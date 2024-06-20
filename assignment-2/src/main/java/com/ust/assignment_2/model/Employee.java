package com.ust.assignment_2.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    double salary;
    int years;
    @ManyToOne
    Department dept;

    public Employee(String name, int age, double salary,int years) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.years = years;
    }
}
