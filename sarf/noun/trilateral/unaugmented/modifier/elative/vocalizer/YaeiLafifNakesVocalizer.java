package sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer;

import java.util.*;

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
    List substitutions = new LinkedList();

    public YaeiLafifNakesVocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (هذا الأهدى، )
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (رأيتُ الأهدى، )
        substitutions.add(new SuffixSubstitution("َيِ","َى"));// EX: (مررتُ على الأهدى، )
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (الأهدَوْنَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (الأهدَيْنَ)
        substitutions.add(new InfixSubstitution("ْيَى","ْيَا"));// EX: (الهديا)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 26:
            switch (noc) {
            case 2:
            case 3:
            case 4:
                return true;
            }
        case 28:
            return noc == 2 || noc == 4;
        }
        return false;
    }
}
