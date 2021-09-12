package sarfwebservice.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sarfwebservice.exceptions.InvalidRootException;
import sarfwebservice.exceptions.RootNotFoundException;
import sarfwebservice.models.RootResult;
import sarfwebservice.services.SarfServiceQuad;
import sarfwebservice.services.SarfServiceTri;

@RestController
@RequestMapping("/sarf")
public class SarfController {

    private final SarfServiceTri sarfServiceTri;
    private final SarfServiceQuad sarfServiceQuad;

    @Autowired
    public SarfController(SarfServiceTri sarfServiceTri, SarfServiceQuad sarfServiceQuad) {
        this.sarfServiceTri = sarfServiceTri;
        this.sarfServiceQuad = sarfServiceQuad;
    }

    @RequestMapping("/{rootLetters}")
    RootResult home(@PathVariable String rootLetters) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }
        if(rootLetters.length() == 3) {
            return getRootResultTri(rootLetters);
        }
        return getRootResultQuad(rootLetters);
    }

    @NotNull
    private RootResult getRootResultTri(String rootLetters) throws Exception {
        var rootResult = sarfServiceTri.getRoots(rootLetters);
        if (rootResult == null || rootResult.isEmpty()) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return rootResult;
    }

    private RootResult getRootResultQuad(String rootLetters) {
        return null;
    }

    private boolean isValidRoot(String rootLetters) {
        if (rootLetters == null || rootLetters.trim().equals("")) {
            return false;
        }

        if (!sarfServiceTri.isArabic(rootLetters)) {
            return false;
        }

        return rootLetters.length() == 3 || rootLetters.length() == 4;
    }
}
