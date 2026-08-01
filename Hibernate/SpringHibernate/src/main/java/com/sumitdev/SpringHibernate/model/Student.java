package com.sumitdev.SpringHibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            unique = true,
            nullable = false,
            insertable = true,
            updatable = false,
            length = 100
    )
    private String email;

    @Column(
            nullable = false,
            scale = 0
    )
    private int age;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

}
