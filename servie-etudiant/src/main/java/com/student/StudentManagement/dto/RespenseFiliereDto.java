package com.student.StudentManagement.dto;

import com.student.StudentManagement.model.ModuleF;
import com.student.StudentManagement.model.Student;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class RespenseFiliereDto {
    private  Long id;
    private String name ;
    //private List<RespenseModuleFDto> modules;
   // private List<ModuleF> modules;
}
