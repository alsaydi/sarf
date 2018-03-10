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
public class ActivePresent1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ActivePresent1Vocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("َيْC2ِيُ","َC2ِي"));// EX: (يَدِي)
        substitutions.add(new ExpressionSuffixSubstitution("َيْC2ِيْ","َC2ِ"));// EX: (لم يَدِ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيِن","َC2ِن"));// EX: (أنتِ تَدِنَّ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيِ","َC2ِ"));// EX: (أنتِ تَدِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيْ","َC2ِي"));// EX: (أنتن تَدِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيُ","َC2ُ"));// EX: (أنتم تَدُونَ)
        substitutions.add(new ExpressionInfixSubstitution("َيْC2ِيَ","َC2ِيَ"));// EX: (أنتما تَدِيان)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (conjugationResult.getRoot().getC1()=='ي' && kov == 30 && noc == 2);
    }
}
