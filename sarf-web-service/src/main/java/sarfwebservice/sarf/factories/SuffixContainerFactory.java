package sarfwebservice.sarf.factories;
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
import org.springframework.stereotype.Service;
import sarf.gerund.trilateral.unaugmented.StandardTrilateralUnaugmentedSuffixContainer;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.INounSuffixContainer;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateFormulaCSuffixContainer;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateFormulaE1SuffixContainer;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateFormulaE2SuffixContainer;
import sarf.noun.trilateral.unaugmented.elative.ElativeSuffixContainer;

@Service
public class SuffixContainerFactory {
    public GenericNounSuffixContainer create() {
        return new GenericNounSuffixContainer();
    }

    public ElativeSuffixContainer createElative() {
        return new ElativeSuffixContainer();
    }

    public INounSuffixContainer createAssimilate(String key) {
        switch (key){
            case "أَفْعَل":
                return new AssimilateFormulaCSuffixContainer();
            case "فَعْلان / فَعْلانة":
                return new AssimilateFormulaE1SuffixContainer();
            case "فَعْلان / فَعْلَى":
                return new AssimilateFormulaE2SuffixContainer();
            default:
                break;
        }
        return new GenericNounSuffixContainer();
    }

    public INounSuffixContainer createStandardGerund() {
        return new StandardTrilateralUnaugmentedSuffixContainer();
    }
}

