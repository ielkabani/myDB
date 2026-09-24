package com.elkabani.mydb.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false, name="id")
    private Long id;

    @Column(nullable=false, name="name")
    private String name;

    @Column(nullable=false, name="email")
    private String email;

    @Column(nullable=false, name="password")
    private String password;

}
