package sarf.verb.trilateral.augmented.modifier.geminator;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الذي يبدأ بالنون    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NStartedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public NStartedGeminator() {
        substitutions.add(new InfixSubstitution("نْن","نّ"));// EX: (انَّمَسَ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (conjugationResult.getRoot().getC1() == 'ن') && kov == 1 && formulaNo == 4;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
