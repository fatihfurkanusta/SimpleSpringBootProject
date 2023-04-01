package com.furkan.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;
    @NotEmpty(message = "Ad Soyad Alanını Boş Geçemezsiniz!")
    @Size(min=1,max = 18)
    private String teacherNameSurname;
    @NotEmpty(message = "Email Alanını Boş Geçemezsiniz!")
    @Email(message = "Uygun formatta mail girmediniz!")
    private String teacherEmail;
    @NotEmpty(message = "Şifre Alanını Boş Geçemezsiniz.")
    @Size(min=5,max = 10)
    private String teacherPassword;
}
