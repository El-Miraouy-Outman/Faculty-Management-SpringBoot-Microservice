package com.miraouy.dto.Response;

import com.miraouy.ClientFeign.Student;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NoteResponseDto {

    private Float note;
   private Student student;
}
