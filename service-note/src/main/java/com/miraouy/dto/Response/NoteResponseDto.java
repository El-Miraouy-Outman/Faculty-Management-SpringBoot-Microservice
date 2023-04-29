package com.miraouy.dto.Response;

import com.miraouy.ClientFeign.Student;
import com.miraouy.model.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponseDto {

    private Float note;
    private  Student student;
    private
}
