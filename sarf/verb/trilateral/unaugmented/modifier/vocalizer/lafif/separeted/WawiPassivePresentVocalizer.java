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
        substitutions.add(new ExpressionSuffixSubstitution("úC2óíõ", "C2óì")); // EX: (íõæŞóì)
        substitutions.add(new ExpressionSuffixSubstitution("úC2óíó", "C2óì")); // EX: (áä íõæŞóì)
        substitutions.add(new ExpressionSuffixSubstitution("úC2óíú", "C2ó")); // EX: (áã íõæŞó)
        substitutions.add(new ExpressionInfixSubstitution("úC2óíú", "C2óíú")); // EX: (ÃäÊä ÊõæŞíäó)
        substitutions.add(new ExpressionInfixSubstitution("úC2óíó", "C2óíó")); // EX: (ÃäÊãÇ ÊõæŞóíóÇä)
        substitutions.add(new ExpressionInfixSubstitution("úC2óíöí", "C2óíú")); // EX: (ÃäÊö ÊõæŞóíúäó)
        substitutions.add(new ExpressionInfixSubstitution("úC2óíöä","C2óíöä"));// EX: (ÃäÊö ÊõæŞóíöäøó)
        substitutions.add(new ExpressionInfixSubstitution("úC2óíõæ", "C2óæú")); // EX: (ÃäÊã ÊõæŞóæúäó)
        substitutions.add(new ExpressionInfixSubstitution("úC2óíõä", "C2óæõä")); // EX: (ÃäÊã ÊõæŞóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC1() != 'æ') {
            return false;
        }

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 29 || kov == 30) && (noc == 2)) ||
                (kov == 30 && (noc == 6 || noc == 4));
    }
}
