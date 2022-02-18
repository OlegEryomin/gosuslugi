package ru.edu.bsu.gosuslugi.entity;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "subdepartment_id")
    private SubdepartmentEnity subdepartment;

    public ServiceEntity() {
    }

    public SubdepartmentEnity getSubdepartment() {
        return subdepartment;
    }

    public void setSubdepartment(SubdepartmentEnity subdepartment) {
        this.subdepartment = subdepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
