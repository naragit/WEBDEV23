package dev.utils.liqdb.entities;

import  jakarta.persistence.*;
import java.util.Date;

@Table(name = "users")
@Entity
public class User
{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname")
    private  String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "createdate")
    private Date createdAt;
}
