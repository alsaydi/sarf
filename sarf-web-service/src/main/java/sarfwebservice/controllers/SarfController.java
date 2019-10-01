package sarfwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sarfwebservice.services.SarfService;

@RestController
public class SarfController {

    private final SarfService sarfService;

    @Autowired
    public SarfController(SarfService sarfService){

        this.sarfService = sarfService;
    }

    @RequestMapping("/{verb}")
    String home(@PathVariable String verb) throws Exception {
        var roots = sarfService.getRoot(verb);
        var firstRoot = roots.get(0);
        return firstRoot.toString();
    }
}
