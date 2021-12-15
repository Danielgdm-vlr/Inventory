package com.forma.inventory.backend.entities;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() { return id;}

    public void setId(Long id) {
        this.id = id;
    }
}
