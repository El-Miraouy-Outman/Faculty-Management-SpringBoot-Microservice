package com.miraouy.servieetudiant.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class RequestModuleFDto {

    private String name ;


}
