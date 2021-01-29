package pl.sdacademy.converterexample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Prosty kontoler aby pokazać mapowanie jak działa, na przykładzie aktorów filmowych
@Controller
public class ActorController {

//    @Autowired
//    private Converter<Object, Object> simpleObjectConverter;
//

    @Autowired
    private ObjectMapper objectMapper;

    @ResponseBody
    @GetMapping(value = "/actor")
    private MovieActor actor() {
        System.out.println(objectMapper);

        MovieActor ma = new MovieActor();

        ma.setName("Janusz");
        ma.setSurname("Gajos");
        return ma;
    }

}
