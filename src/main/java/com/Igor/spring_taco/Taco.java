package com.Igor.spring_taco;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.NotBlank;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min=5, message = "Name must by at least 1 ingredient")
    private String name;
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;
}