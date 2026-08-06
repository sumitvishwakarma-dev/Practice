package com.sumitdev.springJPAHibernate.model;

import com.sun.source.doctree.EscapeTree;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String bio;

    @OneToOne
    @JoinColumn(
            name = "user_id"
    )
    private User user;
}
