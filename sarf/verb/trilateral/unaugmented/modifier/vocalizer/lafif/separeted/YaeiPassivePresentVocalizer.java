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
public class YaeiPassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public YaeiPassivePresentVocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("íúC2óíõ", "æC2óì")); // EX: (íõæÏóì)
        substitutions.add(new ExpressionSuffixSubstitution("íúC2óíó", "æC2óì")); // EX: (áä íõæÏóì)
        substitutions.add(new ExpressionInfixSubstitution("íúC2óíó","æC2óíó"));// EX: (íõæÏóíÇäö)
        substitutions.add(new ExpressionSuffixSubstitution("íúC2óíú", "æC2ó")); // EX: (áã íõæÏó)
        substitutions.add(new ExpressionInfixSubstitution("íúC2óíú","æC2óíú"));// EX: (íõæÏóíúäóÇäøö)
        substitutions.add(new ExpressionInfixSubstitution("íúC2óíöí", "æC2óíú")); // EX: (ÃäÊö ÊõæÏóíúäó)
        substitutions.add(new ExpressionInfixSubstitution("íúC2óíõæ", "æC2óæú")); // EX: (ÃäÊã ÊõæÏóæúäó)
        substitutions.add(new ExpressionInfixSubstitution("íúC2óíõä", "æC2óæõä")); // EX: (ÃäÊã ÊõæÏóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC1() != 'í') {
            return false;
        }

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 29 || kov == 30) && (noc == 2)) ||
                (kov == 30 && (noc == 6 || noc == 4));
    }
}
