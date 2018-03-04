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
public class ActivePresent2Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ActivePresent2Vocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("َوْC2ِيُ", "َC2ِي")); // EX: (يَقِي، يَلِي)
        substitutions.add(new ExpressionSuffixSubstitution("َوْC2ِيْ", "َC2ِ")); // EX: (لم يَقِ، يَلِ)
        substitutions.add(new ExpressionInfixSubstitution("َوْC2ِيِن", "َC2ِن")); // EX: (أنتِ تَقِنَّ، تَلِنَّ)
        substitutions.add(new ExpressionInfixSubstitution("َوْC2ِيِ", "َC2ِ")); // EX: (أنتِ تَقِينَ، تَلِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َوْC2ِيْ", "َC2ِي")); // EX: (أنتن تَقِينَ، تَلِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َوْC2ِيُ", "َC2ُ")); // EX: (أنتم تَقُون، تَقُنَّ، تَلُون، تَلُنَّ)
        substitutions.add(new ExpressionInfixSubstitution("َوْC2ِيَ","َC2ِيَ"));// EX: (أنتما تقيان)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 29 || kov == 30) && (noc == 2)) ||
                (kov == 30 && noc == 6);
    }
}
