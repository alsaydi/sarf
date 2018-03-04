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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {

        substitutions.add(new ExpressionSuffixSubstitution("ÇíúC2öíú","C2ö"));// EX: (Ïö)
        substitutions.add(new ExpressionInfixSubstitution("ÇíúC2öíö","C2ö"));// EX: (ÃäÊö Ïöí)
        substitutions.add(new ExpressionInfixSubstitution("ÇíúC2öíú","C2öí"));// EX: (ÃäÊä Ïöíäó)
        substitutions.add(new ExpressionInfixSubstitution("ÇíúC2öíõ","C2õ"));// EX: (ÃäÊã ÏõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇíúC2öíó","C2öíó"));// EX: (ÃäÊãÇ ÏöíÇ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (conjugationResult.getRoot().getC1()=='í' && kov == 30 && noc == 2);
    }

}
