package ru.edu.bsu.gosuslugi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subdepartment")
public class SubdepartmentEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdepartment")
    private List<ServiceEntity> service;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;


    public SubdepartmentEnity() {
    }

    public List<ServiceEntity> getService() {
        return service;
    }

    public void setService(List<ServiceEntity> service) {
        this.service = service;
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

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
