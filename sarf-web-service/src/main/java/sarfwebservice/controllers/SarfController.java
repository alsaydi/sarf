package sarfwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sarfwebservice.exceptions.InvalidRootException;
import sarfwebservice.exceptions.RootNotFoundException;
import sarfwebservice.services.SarfService;

@RestController
@RequestMapping("/sarf")
public class SarfController {

    private final SarfService sarfService;

    @Autowired
    public SarfController(SarfService sarfService) {

        this.sarfService = sarfService;
    }

    @RequestMapping("/{rootLetters}")
    String home(@PathVariable String rootLetters) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }
        var roots = sarfService.getRoot(rootLetters);
        if (roots == null || roots.isEmpty()) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        var firstRoot = roots.get(0);
        return firstRoot.toString();
    }

    private boolean isValidRoot(String rootLetters) {
        if (rootLetters == null || rootLetters.trim().equals("")) {
            return false;
        }

        if (!sarfService.isArabic(rootLetters)) {
            return false;
        }

        return rootLetters.length() == 3 || rootLetters.length() == 4;
    }
}
