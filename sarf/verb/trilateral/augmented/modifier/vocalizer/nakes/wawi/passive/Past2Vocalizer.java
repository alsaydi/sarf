package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past2Vocalizer() {

        substitutions.add(new InfixSubstitution("æú","í"));// EX: (ÃäÇ ÓõãøöíÊõ¡ ÊõÒõßøöíÊõ)
        substitutions.add(new InfixSubstitution("æó","íó"));// EX: (åæ Óõãøöíó¡ ÊõÒõßøöíó)
        substitutions.add(new InfixSubstitution("øöæõ","øõ"));// EX: (åã ÓõãøõæÇ¡ ÊõÒõßøõæÇ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 22 && formulaNo == 8) || ((kov == 23 || kov == 21) && (formulaNo == 2 || formulaNo == 8));
    }
}
