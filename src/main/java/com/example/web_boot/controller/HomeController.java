package com.example.web_boot.controller;

import com.example.web_boot.bean.students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping
    public String home() {
        return "view/home";
    }

    @GetMapping("student")
    public String showStudents(Model model,
                               @RequestParam("n")Optional<Integer> i) throws Exception{
        System.out.println("ok");
//        File data = ResourceUtils.getFile("classpath:com/example/web_boot/controller/students.json");
        File data = ResourceUtils.getFile("classpath:data/students.json");
        System.out.println("ok");

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<students>> typeReference = new TypeReference<>() {};
        List<students> students = mapper.readValue(data, typeReference);

        Integer n = i.orElse(0);
        model.addAttribute("sv", students.get(n));
        model.addAttribute("i", n);
        model.addAttribute("size", students.size());
        return "view/students";
    }

}
