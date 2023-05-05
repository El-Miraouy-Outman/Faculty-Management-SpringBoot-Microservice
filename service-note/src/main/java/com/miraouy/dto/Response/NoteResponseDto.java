package com.miraouy.dto.Response;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteResponseDto {

    private Float note;
    private  Student student;
    //private Long idModule;
    //private Long idFiliere;
    //private  Filiere filiere;
    private ModuleF module;
}
