package sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer;

import java.util.*;

import sarf.Conjugation;
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
public class C1Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public C1Vocalizer() {
        substitutions.add(new InfixSubstitution("مِوْ","مِي"));// EX: (مِيصال )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return nounFormula.equals("مِفْعَال") && (kov == 11
                && (noc == Conjugation.Second || noc == Conjugation.Third || noc == Conjugation.Fifth || noc == Conjugation.Sixth));
    }

}
