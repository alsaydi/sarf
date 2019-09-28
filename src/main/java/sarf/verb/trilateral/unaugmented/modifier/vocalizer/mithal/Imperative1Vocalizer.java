package sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.*;

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
    private final List<Substitution> substitutions = new ArrayList<>();

    private final List<String> acceptList = new ArrayList<>();
    private final List<String> declineList = new ArrayList<>();

    public Imperative1Vocalizer() {
        acceptList.add("وذر");
        acceptList.add("وسع");
        acceptList.add("وطء");

        declineList.add("وبء");
        declineList.add("وبه");
        declineList.add("وجع");
        declineList.add("وسع");
        declineList.add("وهل");

        substitutions.add(new InfixSubstitution("اوْ",""));
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    /**
     * فحص أحد ثلاثة احتمالات
     * @param conjugationResult NounConjugationResult
     * @return boolean
     */
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Mithal_Wawi_Mahmouz_Ain && noc == Conjugation.Second)
                || (kov == KindOfVerb.Mithal_Wawi && (noc == Conjugation.Second || noc == Conjugation.Sixth))
                || isApplied1(conjugationResult) //احتمال2
                || isApplied2(conjugationResult); // احتمال 3

    }

    private boolean isApplied1(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        //فحص الباب التصريفي أولاً
        if (root.getConjugation() != Conjugation.Forth) return false;

        for (String appliedRoot : acceptList) {
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return true;
        }
        return false;
    }

    private boolean isApplied2(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        //فحص الباب التصريفي أولاً
        if (root.getConjugation() != Conjugation.Third) return false;

        for (String appliedRoot : declineList) {
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return false;
        }
        return true;
    }
}
