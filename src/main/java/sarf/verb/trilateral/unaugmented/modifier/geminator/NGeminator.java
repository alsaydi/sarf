package sarf.verb.trilateral.unaugmented.modifier.geminator;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.SystemConstants;


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
public class NGeminator extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier{

    private List<Substitution> substitutions = new ArrayList<>();
    //أرقام الضمائر التي يمكن التطبيق من أجلها حسب الصيغةة  ماضي أو مضارع أو أمر
    private Map<String, ArrayList<String>> indeciesMap = new HashMap<>();//TODO: is this needed at all?

    public NGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("نْنَ","نَّ"));

        var indecies = new ArrayList<String>(2);
        indecies.add("2");
        indecies.add("13");
        indeciesMap.put(SystemConstants.PAST_TENSE, indecies);

        indecies = new ArrayList<>(2);
        indecies.add("7");
        indecies.add("13");
        indeciesMap.put(SystemConstants.PRESENT_TENSE, indecies);

        indecies = new ArrayList<>(1);
        indecies.add("7");
        indeciesMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, indecies);
        indeciesMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, indecies);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return (conjugationResult.getRoot().getC3()=='ن' && (kov == 1 || kov == 2 || kov == 3 || kov == 5 || kov == 6 || kov == 11 || kov == KindOfVerb.Mithal_Yaee || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee));
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        //it is the same active or passive
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    /*protected List getAppliedPronounsIndecies(String tense) {
        return (List) indeciesMap.get(tense);
    }*/
}
