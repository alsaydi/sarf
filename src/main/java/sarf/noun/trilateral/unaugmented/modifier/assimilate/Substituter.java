package sarf.noun.trilateral.unaugmented.modifier.assimilate;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class Substituter extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    final List<Substitution> substitutions = new ArrayList<>();

    public Substituter() {
        substitutions.add(new InfixSubstitution("اءَا","اوَا"));// EX: (عَمْياوان)
        substitutions.add(new InfixSubstitution("اءَي","اوَي"));// EX: (عَمْياوين)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getNounFormula().equals("فَعْلان");
    }
}
