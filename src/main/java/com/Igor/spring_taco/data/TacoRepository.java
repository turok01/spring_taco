package com.Igor.spring_taco.data;

import com.Igor.spring_taco.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    //Taco save(Taco design);
}
