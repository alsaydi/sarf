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
        substitutions.add(new ExpressionSuffixSubstitution("óíúC2öíõ","óC2öí"));// EX: (íóÏöí)
        substitutions.add(new ExpressionSuffixSubstitution("óíúC2öíú","óC2ö"));// EX: (áã íóÏö)
        substitutions.add(new ExpressionInfixSubstitution("óíúC2öíöä","óC2öä"));// EX: (ÃäÊö ÊóÏöäøó)
        substitutions.add(new ExpressionInfixSubstitution("óíúC2öíö","óC2ö"));// EX: (ÃäÊö ÊóÏöíäó)
        substitutions.add(new ExpressionInfixSubstitution("óíúC2öíú","óC2öí"));// EX: (ÃäÊä ÊóÏöíäó)
        substitutions.add(new ExpressionInfixSubstitution("óíúC2öíõ","óC2õ"));// EX: (ÃäÊã ÊóÏõæäó)
        substitutions.add(new ExpressionInfixSubstitution("óíúC2öíó","óC2öíó"));// EX: (ÃäÊãÇ ÊóÏöíÇä)
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
