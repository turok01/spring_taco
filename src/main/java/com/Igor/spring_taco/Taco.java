package com.Igor.spring_taco;

import java.util.List;
import lombok.Data;

@Data
public class Taco {
    private String name;
    private List<String> ingredients;
}