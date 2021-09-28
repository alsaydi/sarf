package sarfwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sarfwebservice.exceptions.InvalidRootException;
import sarfwebservice.exceptions.RootNotFoundException;
import sarfwebservice.models.RootResult;
import sarfwebservice.models.VerbConjugations;
import sarfwebservice.services.SarfServiceQuad;
import sarfwebservice.services.SarfServiceTri;

import java.util.List;

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
    List<RootResult> home(@PathVariable String rootLetters) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }
        if (rootLetters.length() == 3) {
            return getRootResultTri(rootLetters);
        }
        return getRootResultQuad(rootLetters);
    }

    @RequestMapping("/active/{rootLetters}")
    VerbConjugations home(@PathVariable String rootLetters
            , @RequestParam boolean augmented
            , @RequestParam int cclass
            , @RequestParam int formula) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }

        if (rootLetters.length() == 3) {
            return getActiveVerbConjugationsTri(rootLetters, augmented, cclass, formula);
        }
        return getActiveVerbConjugationsQuad(rootLetters, augmented, cclass, formula);
    }

    private List<RootResult> getRootResultTri(String rootLetters) throws Exception {
        var rootResult = sarfServiceTri.getRoots(rootLetters);
        if (rootResult == null || rootResult.isEmpty()) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return rootResult;
    }

    private List<RootResult> getRootResultQuad(String rootLetters) throws Exception {
        var rootResult = sarfServiceQuad.getRoots(rootLetters);
        if (rootResult == null || rootResult.isEmpty()) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return rootResult;
    }

    private VerbConjugations getActiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceTri.getActiveVerbConjugationsTri(rootLetters, augmented, cclass, formula);
        if(result == null && result.getPast() == null || result.getPast().isEmpty()) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return  result;
    }

    private VerbConjugations getActiveVerbConjugationsQuad(String rootLetters, boolean augmented, int cclass, int formula) {
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
