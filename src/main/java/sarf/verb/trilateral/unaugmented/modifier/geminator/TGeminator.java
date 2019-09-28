package sarf.verb.trilateral.unaugmented.modifier.geminator;

import java.util.*;

import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
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
    private final List<Substitution> substitutions = new ArrayList<>();
    private final List<String> appliedPronounsIndexes = new ArrayList<>(6);

    public TGeminator() {
        substitutions.add(new InfixSubstitution("تْتُ", "تُّ"));
        substitutions.add(new InfixSubstitution("تْتَ", "تَّ"));
        substitutions.add(new InfixSubstitution("تْتِ", "تِّ"));

        appliedPronounsIndexes.add("1");
        appliedPronounsIndexes.add("3");
        appliedPronounsIndexes.add("4");
        appliedPronounsIndexes.add("5");
        appliedPronounsIndexes.add("6");
        appliedPronounsIndexes.add("7");
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    protected List<String> getAppliedPronounsIndexes() {
        return appliedPronounsIndexes;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return (conjugationResult.getRoot().getC3()=='ت' && (kov == KindOfVerb.Salim || kov == KindOfVerb.Mudaaf || kov == KindOfVerb.Mahmouz_Faa_Mudaaf || kov == KindOfVerb.Mahmouz_Faa || kov == KindOfVerb.Mahmouz_Ain || kov == KindOfVerb.Mithal_Wawi || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee));
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
