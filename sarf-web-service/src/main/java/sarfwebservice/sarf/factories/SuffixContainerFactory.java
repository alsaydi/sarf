package sarfwebservice.sarf.factories;

import org.springframework.stereotype.Service;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.trilateral.unaugmented.elative.ElativeSuffixContainer;

@Service
public class SuffixContainerFactory {
    public GenericNounSuffixContainer create() {
        return new GenericNounSuffixContainer();
    }

    public ElativeSuffixContainer createElative() {
        return new ElativeSuffixContainer();
    }
}

