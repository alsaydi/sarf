package sarf.gerund.modifier.trilateral.unaugmented.nomen.geminator;

import java.util.*;

import sarf.noun.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.ConjugationResult;

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
public class Geminator2 extends TrilateralNounSubstitutionApplier {
private final List<Substitution> substitutions = new ArrayList<>();

    public Geminator2() {
        substitutions.add(new InfixSubstitution("َوْيَ","َيَّ"));// EX: (شيَّة، ليَّة)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() =='و' && conjugationResult.getRoot().getC3() == 'ي';
    }
}
