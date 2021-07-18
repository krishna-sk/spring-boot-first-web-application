package com.springboot.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private int id;
    private String user;
    @Size(min=10,message="Enter atleast 10 Characters!")
    private String desc;
    private Date targetDate;
    private boolean done;
}