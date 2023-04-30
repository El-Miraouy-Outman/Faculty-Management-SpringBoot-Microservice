package com.miraouy.servieetudiant.dto;

import com.miraouy.servieetudiant.model.ModuleF;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestFiliereDto {
    private String name ;
    private List<ModuleF> modules;
}
