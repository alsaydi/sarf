package sarf.verb.trilateral.unaugmented.modifier.geminator;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:
 * الادغام للمنتهي بالنون هو نفسه من أجل كل الصيغ للمعلوم وللمجهول
 * ولكن تختلف فيما بينها بأرقام الضمائر
 * فهو الصف الأب للثلاث الصفوف في الماضي والمضارع والأمر
 * A composite pattern is applied here
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NGeminator extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();
    //أرقام الضمائر التي يمكن التطبيق من أجلها حسب الصيغةة  ماضي أو مضارع أو أمر
    public NGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("نْنَ","نَّ"));
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return (conjugationResult.getRoot().getC3()=='ن' && (kov == KindOfVerb.Salim || kov == KindOfVerb.Mudaaf || kov == KindOfVerb.Mahmouz_Faa_Mudaaf || kov == KindOfVerb.Mahmouz_Faa || kov == KindOfVerb.Mahmouz_Ain || kov == KindOfVerb.Mithal_Wawi || kov == KindOfVerb.Mithal_Yaee || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee));
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        //it is the same active or passive
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
