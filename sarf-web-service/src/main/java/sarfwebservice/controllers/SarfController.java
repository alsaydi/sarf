package sarfwebservice.controllers;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sarfwebservice.exceptions.InvalidRootException;
import sarfwebservice.exceptions.RootNotFoundException;
import sarfwebservice.models.GerundConjugations;
import sarfwebservice.models.NounConjugations;
import sarfwebservice.models.RootResult;
import sarfwebservice.models.VerbConjugations;
import sarfwebservice.services.SarfServiceQuad;
import sarfwebservice.services.SarfServiceTri;

import java.util.List;

@RestController
@RequestMapping("/sarf")
@CrossOrigin(origins = {"https://sarf.one", "https://www.sarf.one", "http://localhost:4200"})
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
    List<VerbConjugations> active(@PathVariable String rootLetters
            , @RequestParam boolean augmented
            , @RequestParam int cclass
            , @RequestParam int formula) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }

        if (rootLetters.length() == 3) {
            return getActiveVerbConjugationsTri(rootLetters, augmented, cclass, formula);
        }
        return List.of(getActiveVerbConjugationsQuad(rootLetters, augmented, cclass, formula));
    }

    @RequestMapping("/passive/{rootLetters}")
    List<VerbConjugations> passive(@PathVariable String rootLetters
            , @RequestParam boolean augmented
            , @RequestParam int cclass
            , @RequestParam int formula) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }

        if (rootLetters.length() == 3) {
            return getPassiveVerbConjugationsTri(rootLetters, augmented, cclass, formula);
        }
        return List.of(gePassiveVerbConjugationsQuad(rootLetters, augmented, cclass, formula));
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

    private List<VerbConjugations> getActiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceTri.getActiveVerbConjugationsTri(rootLetters, augmented, cclass, formula);
        if(result == null) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return result;
    }

    private List<VerbConjugations> getPassiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceTri.getPassiveVerbConjugationsTri(rootLetters, augmented, cclass, formula);
        if(result == null) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return  result;
    }

    private VerbConjugations getActiveVerbConjugationsQuad(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceQuad.getActiveVerbConjugations(rootLetters, augmented, cclass, formula);
        if(result == null && result.getPast() == null || result.getPast().isEmpty()) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return  result;
    }

    private VerbConjugations gePassiveVerbConjugationsQuad(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceQuad.getPassiveVerbConjugations(rootLetters, augmented, cclass, formula);
        if(result == null && result.getPast() == null || result.getPast().isEmpty()) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return  result;
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

    @RequestMapping("/nouns/{rootLetters}")
    NounConjugations nouns(@PathVariable String rootLetters
            , @RequestParam boolean augmented
            , @RequestParam int cclass
            , @RequestParam int formula) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }

        if (rootLetters.length() == 3) {
            return getNounConjugationsTri(rootLetters, augmented, cclass, formula);
        }
        return getNounConjugationsQuad(rootLetters, augmented, cclass, formula);
    }

    private NounConjugations getNounConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceTri.getNouns(rootLetters, augmented, cclass, formula);
        if(result == null) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return  result;
    }

    private NounConjugations getNounConjugationsQuad(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceQuad.getNouns(rootLetters, augmented, cclass, formula);
        if (result == null) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return result;
    }

    @RequestMapping("/gerunds/{rootLetters}")
    GerundConjugations gerunds(@PathVariable String rootLetters
            , @RequestParam boolean augmented
            , @RequestParam int cclass
            , @RequestParam int formula) throws Exception {
        if (!isValidRoot(rootLetters)) {
            throw new InvalidRootException(String.format("ينبغي تحديد جذر مناسب للكلمة - %s.", rootLetters));
        }

        if (rootLetters.length() == 3) {
            return getGerundConjugationsTri(rootLetters, augmented, cclass, formula);
        }
        return getGerundConjugationsQuad(rootLetters, augmented, cclass, formula);
    }

    private GerundConjugations getGerundConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceTri.getGerunds(rootLetters, augmented, cclass, formula);
        if(result == null) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return  result;
    }

    private GerundConjugations getGerundConjugationsQuad(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        var result = this.sarfServiceQuad.getGerunds(rootLetters, augmented, cclass, formula);
        if (result == null) {
            throw new RootNotFoundException(String.format("لا يوجد جذر لـ: %s", rootLetters));
        }
        return result;
    }
}
