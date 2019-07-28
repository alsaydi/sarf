package sarf.noun.trilateral.unaugmented.instrumental;

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
    private StandardInstrumentalConjugator() {
    }

    private static final StandardInstrumentalConjugator instance = new StandardInstrumentalConjugator();

    public static StandardInstrumentalConjugator getInstance() {
        return instance;
    }

    private static final List<String> formulas = new LinkedList<>();
    static {
        formulas.add("مِفْعَل");
        formulas.add("مِفْعَلَة");
        formulas.add("مِفْعَال");
        formulas.add("فَعَّالَة");
    }

    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, int formulaNo) {
        String formulaClassName = getClass().getPackage().getName()+".standard.NounFormula"+formulaNo;
        Object [] parameters = {root, suffixNo+""};

        try {
            return (NounFormula) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, int formulaNo) {
        List<NounFormula> result = new LinkedList<>();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }
        return result;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        return createNounList(root, formulas.indexOf(formulaName) + 1);
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        //فقط للفعل المتعدي
        if (root.getTransitive().equals("م") || root.getTransitive().equals("ك"))
            return formulas;
        return new LinkedList<>();
    }


}
