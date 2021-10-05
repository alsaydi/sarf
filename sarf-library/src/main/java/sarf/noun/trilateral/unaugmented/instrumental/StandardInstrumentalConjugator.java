package sarf.noun.trilateral.unaugmented.instrumental;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class StandardInstrumentalConjugator implements IUnaugmentedTrilateralNounConjugator{
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public StandardInstrumentalConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    private static final List<String> formulas = new LinkedList<>();
    static {
        formulas.add("مِفْعَل");
        formulas.add("مِفْعَلَة");
        formulas.add("مِفْعَال");
        formulas.add("فَعَّالَة");
    }

    private NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        String formulaClassName = getClass().getPackage().getName()+".standard.NounFormula"+formulaNo;
        Object [] parameters = {root, suffixNo+"", genericNounSuffixContainer};

        try {
            return (NounFormula) Class.forName(formulaClassName).getConstructor(
                    root.getClass(), "".getClass(), genericNounSuffixContainer.getClass()
            ).newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, int formulaNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        List<NounFormula> result = new LinkedList<>();
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            NounFormula noun = createNoun(root, i, formulaNo, genericNounSuffixContainer);
            result.add(noun);
        }
        return result;
    }

    /**
     * @deprecated Use the version that takes an instance of type GenericNounSuffixContainer
     * @param root جذر مجرد ثلاثي
     * @param formulaName وزن إسم الآلة
     * @return  أوزان قائمة
     */
    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        return createNounList(root, formulaName, this.genericNounSuffixContainer);
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName, GenericNounSuffixContainer genericNounSuffixContainer) {
        return createNounList(root, formulas.indexOf(formulaName) + 1, genericNounSuffixContainer);
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        //فقط للفعل المتعدي
        if (root.getTransitive().equals("م") || root.getTransitive().equals("ك"))
            return formulas;
        return new LinkedList<>();
    }


}
