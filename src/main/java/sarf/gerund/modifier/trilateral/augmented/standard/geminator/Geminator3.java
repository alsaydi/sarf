package sarf.gerund.modifier.trilateral.augmented.standard.geminator;

import java.util.*;

import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.*;

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
public class Geminator3 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List<Substitution> substitutions = new LinkedList<>();

    public Geminator3() {
        substitutions.add(new InfixSubstitution("تْت","تّ"));// EX: (اتِّباعٌ، اتِّآم)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return conjugationResult.getRoot().getC1() == 'ت' && (kov == 1 || kov == KindOfVerb.Mahmouz_Ain) && formulaNo == 5;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
