package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ْ", "ِC3ْ")); // EX: (أُقِمْتُ، استدرتُ،)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ّ", "ِC3ّ")); // EX: (أُمِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3َ", "ِيC3َ")); // EX: (أُقِيمَ، استُدِير،)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ُ", "ِيC3ُ")); // EX: (أُقِيمُوا، استُدِيروا،)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ْ", "ِC3ْ")); // EX: (انْقِدْتُ، اقْتِدْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ّ", "ِC3ّ")); // EX: (اختِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3َ", "ِيC3َ")); // EX: (انقِيدَ، اقْتِيدَ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ُ", "ِيC3ُ")); // EX: (انقِيدُوا، اقتِيدُوا)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 16 || kov == 17) && formulaNo == 1) ||
                ((kov == 15 || kov == 17) && formulaNo == 4) ||
                ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 5) ||
                ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 9);
    }
}
