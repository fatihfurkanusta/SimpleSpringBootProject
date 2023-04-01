package com.furkan.controller;

import com.furkan.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    //http://localhost:8080/
    @GetMapping({"/", "index"})     // Opsiyonel Yapı. option root{}
    public String index(){
        return "index";
    }

    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1(){
        return "thymeleaf1";
    }

    //http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim.-1");
        model.addAttribute("key_model2","Ben Modelden geldim.-2");
        return "thymeleaf1";
    }

    //http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim.-1");
        model.addAttribute("key_model2","Ben Modelden geldim.-2");
        return "thymeleaf_file/thymeleaf3";
    }

    //http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model){
        model.addAttribute("key_model1","Ben Modelden geldim.");
        return "thymeleaf4";
    }

    // Model Object Göndermek

    //http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model){
        model.addAttribute("key_model1","text");

        ProductDto productDto = ProductDto.builder().productId(0L).productName("Ürün Adı").productPrice(2500).build();

        model.addAttribute("key_model2",productDto);

        return "thymeleaf5";
    }

    ////////////////////// Model Object List göndermek /////////////////
    //http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObjectList(Model model){
        model.addAttribute("key_model1","text");
        List<ProductDto> myList = new ArrayList<>();

        myList.add(ProductDto.builder().productId(0L).productName("Ürün Adı1").productPrice(1500).build());
        myList.add(ProductDto.builder().productId(1L).productName("Ürün Adı2").productPrice(2500).build());
        myList.add(ProductDto.builder().productId(2L).productName("Ürün Adı3").productPrice(3500).build());
        myList.add(ProductDto.builder().productId(3L).productName("Ürün Adı4").productPrice(4500).build());

        model.addAttribute("productList", myList);
        return "thymeleaf6";
    }

    //http://localhost:8080/thymeleaf7
    @GetMapping({"/thymeleaf7","/thymeleaf7/{id}"})
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name="id", required = false) Long id){
        if(id!=null){
            model.addAttribute("key_model1","id "+id);
        }else{
            model.addAttribute("key_model1","id bulunamadı");
        }
        return "thymeleaf7";
    }
}
