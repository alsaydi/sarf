package sarftests.noun.tri.unaugmented;

import com.google.inject.Inject;
import sarf.noun.NounFormula;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.ExaggerationModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmphasizedActiveParticipleNounProvider implements INounProvider {

    private final Common common;
    private final StandardExaggerationConjugator standardExaggerationConjugator;
    private final NonStandardExaggerationConjugator nonStandardExaggerationConjugator;
    private final ExaggerationModifier exaggerationModifier;

    @Inject
    public EmphasizedActiveParticipleNounProvider(Common common, StandardExaggerationConjugator standardExaggerationConjugator
    , NonStandardExaggerationConjugator nonStandardExaggerationConjugator
    , ExaggerationModifier exaggerationModifier){
        this.common = common;
        this.standardExaggerationConjugator = standardExaggerationConjugator;
        this.nonStandardExaggerationConjugator = nonStandardExaggerationConjugator;
        this.exaggerationModifier = exaggerationModifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula,  int conjugations) {
        var locale = new Locale("AR", "YE", "");
        var collator = Collator.getInstance(locale);
        collator.setStrength(Collator.NO_DECOMPOSITION);
        var root = common.createRoot(rootLetters, conjugations);
        var kov = common.getKindOfVerb(rootLetters);
        List<NounFormula> rawNouns;
        formula = null == formula ? "فَعَّال": formula;
        if(collator.compare(formula, "فَعَّال") == 0){
            rawNouns = standardExaggerationConjugator.createNounList(root, formula);
            standardExaggerationConjugator.getAppliedFormulaList(root);
        }else{
            rawNouns = nonStandardExaggerationConjugator.createNounList(root, formula);
        }
        var conjugationResult = exaggerationModifier.build(root, kov, rawNouns, formula);
        var result = new ArrayList<String>();
        for (var n : conjugationResult.getFinalResult()){
            result.add(n.toString());
        }
        return result;
    }
}
