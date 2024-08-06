package com.example.web_boot.bean;

import lombok.Data;

@Data
public class SinhVien {
    private int id;
    private String name;
    private String major;
    private Boolean gender;
    private int age;
    private String subject;
    private Contact contact;
}
