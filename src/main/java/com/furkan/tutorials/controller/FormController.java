package com.furkan.tutorials.controller;

import com.furkan.tutorials.dto.TeacherDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormController {

    //////////    FORM    /////////
    // @GetMapping
    // @PostMapping
    // @PutMapping
    // @DeleteMapping

    // getGetMethod
    //http://localhost:8080/form
    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("cv_teacher", new TeacherDto());
        return "form_post/formvalidation";
    }

    // PostMethod
    //http://localhost:8080/form
    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("cv_teacher") TeacherDto teacherDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata Bulundu...");
            System.err.println("Hata Bulundu...");
            return "form_post/formvalidation";
        }
        log.info("Success "+teacherDto);
        // database kaydetme alanı
        //dosyaya yazma alanı

        return "form_post/success";
    }
}
