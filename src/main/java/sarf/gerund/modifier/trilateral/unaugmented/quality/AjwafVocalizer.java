package sarf.gerund.modifier.trilateral.unaugmented.quality;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

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
public class AjwafVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    AjwafVocalizer() {
        substitutions.add(new InfixSubstitution("ِوْ", "ِي")); // EX: ( قِيمَة، )
        substitutions.add(new InfixSubstitution("ِيْ", "ِي")); // EX: ( بِيعَة، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == 15 || kov == 16 || kov == KindOfVerb.Ajwaf_Wawi) {
            switch (noc) {
                case First:
                case Forth:
                case Fifth:
                    return true;
            }


            return noc == Conjugation.Second || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) {
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        }
        return false;
    }
}
