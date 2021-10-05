package sarfwebservice.sarf.factories;

import org.springframework.stereotype.Service;
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
}

