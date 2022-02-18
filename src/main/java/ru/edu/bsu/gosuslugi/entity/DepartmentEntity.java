package ru.edu.bsu.gosuslugi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<SubdepartmentEnity> subdepartment;

    public DepartmentEntity() {
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

    public List<SubdepartmentEnity> getSubdepartment() {
        return subdepartment;
    }

    public void setSubdepartment(List<SubdepartmentEnity> subdepartment) {
        this.subdepartment = subdepartment;
    }

    public void setName(String name) {
        this.name = name;
    }
}
