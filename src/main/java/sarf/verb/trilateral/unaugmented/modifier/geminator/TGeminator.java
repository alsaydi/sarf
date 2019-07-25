package sarf.verb.trilateral.unaugmented.modifier.geminator;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:
 * القوانين الآتية خاصة بالضمائر (أنا)، و(أنتَ)، و(أنتِ)، و(أنتما)، و(أنتم)، و(أنتنَّ) فقط [أي الأرقام
 * 1 و 3 و 4 و 5 و 6 و 7  في جدول الأفعال]
 * يستعمل نفسه من أجل كل الصيغ الماضي والمضارع والأمر
 * للمعلوم وللمجهول
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
    private List<Substitution> substitutions = new ArrayList<>();
    private List<String> appliedPronounsIndecies = new ArrayList<>(6);

    public TGeminator() {
        substitutions.add(new InfixSubstitution("تْتُ", "تُّ"));
        substitutions.add(new InfixSubstitution("تْتَ", "تَّ"));
        substitutions.add(new InfixSubstitution("تْتِ", "تِّ"));

        appliedPronounsIndecies.add("1");
        appliedPronounsIndecies.add("3");
        appliedPronounsIndecies.add("4");
        appliedPronounsIndecies.add("5");
        appliedPronounsIndecies.add("6");
        appliedPronounsIndecies.add("7");
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    protected List getAppliedPronounsIndecies() {
        return appliedPronounsIndecies;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return (conjugationResult.getRoot().getC3()=='ت' && (kov == 1 || kov == 2 || kov == 3 || kov == 5 || kov == 6 || kov == 11 || kov == 17 || kov == 20));
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }



}
