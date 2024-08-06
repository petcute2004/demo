package com.example.web_boot.controller;

import com.example.web_boot.bean.SinhVien;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Controller
public class SinhVienController {

    @GetMapping("svdisplay")
    private String display(Model model){
        return "view/SinhVien";
    }

    @GetMapping("sinhvien")
    private String sinhVien(Model model,
                            @RequestParam("n")Optional<Integer> i
                            ) throws Exception{
        String path = "classpath:data/SinhVien.json";
        File data = ResourceUtils.getFile(path);

        ObjectMapper mapper = new ObjectMapper();
        TypeReference type = new TypeReference<List<SinhVien>>(){};
        List<SinhVien> sv = (List<SinhVien>) mapper.readValue(data, type);

        Integer n = i.orElse(0);
        model.addAttribute("sv", sv.get(n));
        model.addAttribute("i", n);
        model.addAttribute("size", sv.size());
        return "view/SinhVien";
    }




}
