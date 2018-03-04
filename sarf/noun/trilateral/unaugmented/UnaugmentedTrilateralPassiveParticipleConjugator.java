package sarf.noun.trilateral.unaugmented;

import sarf.verb.trilateral.unaugmented.*;
import sarf.noun.*;
import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ≈‰‘«¡ «”„ «·„›⁄Ê· «·À·«ÀÌ «·„Ã—œ    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedTrilateralPassiveParticipleConjugator implements IUnaugmentedTrilateralNounConjugator{
    private UnaugmentedTrilateralPassiveParticipleConjugator() {
    }

    private static UnaugmentedTrilateralPassiveParticipleConjugator instance = new UnaugmentedTrilateralPassiveParticipleConjugator();

    public static UnaugmentedTrilateralPassiveParticipleConjugator getInstance() {
        return instance;
    }

    public UnaugmentedTrilateralPassiveParticiple createNoun(UnaugmentedTrilateralRoot root, int suffixIndex) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        return new UnaugmentedTrilateralPassiveParticiple(root, suffix);
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List result = new ArrayList(18);
        for (int i=0; i<18; i++)
            result.add(createNoun(root, i));
        return result;

    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        return null;
    }

}
