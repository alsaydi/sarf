package sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

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
public class WawiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public WawiLafifNakesVocalizer() {
        substitutions.add(new SuffixSubstitution("َوُ","َى"));// EX: (هذا الأعلى، )
        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (رأيتُ الأعلى، )
        substitutions.add(new SuffixSubstitution("َوِ","َى"));// EX: (مررتُ على الأعلى، )
        substitutions.add(new InfixSubstitution("َوَ","َيَ"));// EX: (الأعليان)
        substitutions.add(new InfixSubstitution("َوُو","َوْ"));// EX: (الأعلَوْن)
        substitutions.add(new InfixSubstitution("َوِي","َيْ"));// EX: (الأعلَيْن)
        substitutions.add(new InfixSubstitution("ْوَى","ْيَا"));// EX: (العليا)
        substitutions.add(new InfixSubstitution("ْوَي","ْيَي"));// EX: (عُلْيَيَان)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        if (kov != 23) {
            return false;
        }

        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        switch (noc) {
        case 1:
        case 3:
        case 4:
        case 5:
            return true;
        }

        return false;
    }
}
