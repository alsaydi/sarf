package sarf.gerund.modifier.trilateral.augmented.standard.geminator;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;



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
public class Geminator3 extends TrilateralNounSubstitutionApplier{

    private final List<Substitution> substitutions = new LinkedList<>();

    public Geminator3() {
        substitutions.add(new InfixSubstitution("تْت","تّ"));// EX: (اتِّباعٌ، اتِّآم)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return triAugmentedConjugationResult.getRoot().getC1() == 'ت' && (kov == KindOfVerb.Salim || kov == KindOfVerb.Mahmouz_Ain) && formulaNo == 5;
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
