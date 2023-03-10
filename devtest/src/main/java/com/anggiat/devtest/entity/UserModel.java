package com.anggiat.devtest.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
@Getter
@Setter
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone" , unique = true)
    private String phone;
    @Column(name = "token" , unique = true)
    private String token;

    public UserModel() {
    }

    public UserModel(long id, String name, String phone, String token) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.token = token;
    }
}
