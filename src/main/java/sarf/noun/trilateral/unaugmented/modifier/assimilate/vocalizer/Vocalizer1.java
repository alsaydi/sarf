package sarf.noun.trilateral.unaugmented.modifier.assimilate.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;

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
public class Vocalizer1 extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Vocalizer1() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (هذا الأعمى، )
        substitutions.add(new SuffixSubstitution("ِيَ", "َى")); // EX: (رأيتُ الأعمى ، )
        substitutions.add(new SuffixSubstitution("ِيِ", "َى")); // EX: (مررتُ على الأعمى ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return nounFormula.equals("أفعل") && (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain || kov == KindOfVerb.Naqis_Yaee) && noc == Conjugation.Forth;
    }

}
