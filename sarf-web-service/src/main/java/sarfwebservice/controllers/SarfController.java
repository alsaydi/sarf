package sarfwebservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SarfController {
    @RequestMapping("/")
    String home() {
        return "فعل يفعل فعلاً";
    }
}
