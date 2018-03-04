package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
public class WawiPassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public WawiPassivePresentVocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("ْC2َيُ", "C2َى")); // EX: (يُوقَى)
        substitutions.add(new ExpressionSuffixSubstitution("ْC2َيَ", "C2َى")); // EX: (لن يُوقَى)
        substitutions.add(new ExpressionSuffixSubstitution("ْC2َيْ", "C2َ")); // EX: (لم يُوقَ)
        substitutions.add(new ExpressionInfixSubstitution("ْC2َيْ", "C2َيْ")); // EX: (أنتن تُوقينَ)
        substitutions.add(new ExpressionInfixSubstitution("ْC2َيَ", "C2َيَ")); // EX: (أنتما تُوقَيَان)
        substitutions.add(new ExpressionInfixSubstitution("ْC2َيِي", "C2َيْ")); // EX: (أنتِ تُوقَيْنَ)
        substitutions.add(new ExpressionInfixSubstitution("ْC2َيِن","C2َيِن"));// EX: (أنتِ تُوقَيِنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC2َيُو", "C2َوْ")); // EX: (أنتم تُوقَوْنَ)
        substitutions.add(new ExpressionInfixSubstitution("ْC2َيُن", "C2َوُن")); // EX: (أنتم تُوقَوُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC1() != 'و') {
            return false;
        }

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 29 || kov == 30) && (noc == 2)) ||
                (kov == 30 && (noc == 6 || noc == 4));
    }
}
