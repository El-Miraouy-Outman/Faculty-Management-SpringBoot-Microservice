package com.miraouy.dto.Request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoteRequestDto {

    private Float note;
    private Long apogee;
    private Long idModule;
}
