package sarf.verb.trilateral.unaugmented.modifier.geminator;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:
 * ÇáŞæÇäíä ÇáÂÊíÉ ÎÇÕÉ ÈÇáÖãÇÆÑ (ÃäÇ)¡ æ(ÃäÊó)¡ æ(ÃäÊö)¡ æ(ÃäÊãÇ)¡ æ(ÃäÊã)¡ æ(ÃäÊäøó) İŞØ [Ãí ÇáÃÑŞÇã
 * 1 æ 3 æ 4 æ 5 æ 6 æ 7  İí ÌÏæá ÇáÃİÚÇá]
 * íÓÊÚãá äİÓå ãä ÃÌá ßá ÇáÕíÛ ÇáãÇÖí æÇáãÖÇÑÚ æÇáÃãÑ
 * ááãÚáæã æááãÌåæá
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class TGeminator extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier{

    private List substitutions = new LinkedList();
    private List appliedPronounsIndecies = new ArrayList(6);

    public TGeminator() {
        substitutions.add(new InfixSubstitution("ÊúÊõ", "Êøõ"));
        substitutions.add(new InfixSubstitution("ÊúÊó", "Êøó"));
        substitutions.add(new InfixSubstitution("ÊúÊö", "Êøö"));

        appliedPronounsIndecies.add("1");
        appliedPronounsIndecies.add("3");
        appliedPronounsIndecies.add("4");
        appliedPronounsIndecies.add("5");
        appliedPronounsIndecies.add("6");
        appliedPronounsIndecies.add("7");
    }

    public List getSubstitutions() {
        return substitutions;
    }

    protected List getAppliedPronounsIndecies() {
        return appliedPronounsIndecies;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        return (conjugationResult.getRoot().getC3()=='Ê' && (kov == 1 || kov == 2 || kov == 3 || kov == 5 || kov == 6 || kov == 11 || kov == 17 || kov == 20));
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }



}
