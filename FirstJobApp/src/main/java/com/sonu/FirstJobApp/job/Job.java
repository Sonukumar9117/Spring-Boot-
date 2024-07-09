package com.sonu.FirstJobApp.job;

import jakarta.persistence.*;

//This is a job class
@Entity
//@Table(name="job_tale")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    private  String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    //This default constructor is required without it
    public Job(){
    }
    public Job(Long id, String title, String description, String minSalary, String location, String maxSalary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.location = location;
        this.maxSalary = maxSalary;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
