package sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer;

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
public class YaeiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public YaeiLafifNakesVocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (هذا الأهدى، )
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (رأيتُ الأهدى، )
        substitutions.add(new SuffixSubstitution("َيِ","َى"));// EX: (مررتُ على الأهدى، )
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (الأهدَوْنَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (الأهدَيْنَ)
        substitutions.add(new InfixSubstitution("ْيَى","ْيَا"));// EX: (الهديا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == 26) {
            return noc == Conjugation.Second
                    || noc == Conjugation.Third
                    || noc == Conjugation.Forth;

//            switch (noc) {
////            case 2:
////            case 3:
////            case 4:return true;
//            }
        } else if (kov == 28) {//return noc == 2 || noc == Conjugation.Forth;
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        }
        return false;
    }
}
