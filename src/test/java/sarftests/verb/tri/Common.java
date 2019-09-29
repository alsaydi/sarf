package sarftests.verb.tri;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import sarf.KindOfVerb;
import sarf.SarfDictionary;
import sarf.kov.KovRulesManager;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.List;

import static org.assertj.core.api.Assertions.fail;

@Singleton
public final class Common {
    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;

    @Inject
    public Common(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager){
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
    }
    public UnaugmentedTrilateralRoot createRoot(String verb, int conjugation) {
        List<UnaugmentedTrilateralRoot> unaugmentedList = null;
        try {
            unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(verb);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assert unaugmentedList != null;
        return unaugmentedList.stream()
                .filter(r -> r.getConjugation().getValue() == conjugation)
                .findFirst().orElseThrow();
    }

    public KindOfVerb getKindOfVerb(String rootLetters) {
        if (null == rootLetters || rootLetters.length() < 3 || rootLetters.length() > 4) {
            throw new IllegalArgumentException("invalid verb");
        }
        if (rootLetters.length() == 3) {
            return kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        }
        return kovRulesManager.getQuadrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2), rootLetters.charAt(3)).getKov();
    }
}
