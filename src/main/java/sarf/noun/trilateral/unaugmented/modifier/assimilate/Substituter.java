package sarf.noun.trilateral.unaugmented.modifier.assimilate;

import java.util.*;

import sarf.noun.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.noun.trilateral.unaugmented.modifier.*;
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
public class Substituter extends TrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    Substituter() {
        substitutions.add(new InfixSubstitution("اءَا","اوَا"));// EX: (عَمْياوان)
        substitutions.add(new InfixSubstitution("اءَي","اوَي"));// EX: (عَمْياوين)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getNounFormula().equals("فَعْلان");
    }
}
