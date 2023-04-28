package com.miraouy.servieetudiant.models;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "student",types = Student.class)
public interface StudentProjection {
    public String getApogee();
    public Long getId();
    public String getName();
    public String getPrenom();

}
