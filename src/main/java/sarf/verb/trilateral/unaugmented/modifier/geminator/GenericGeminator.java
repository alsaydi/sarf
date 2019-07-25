package sarf.verb.trilateral.unaugmented.modifier.geminator;

import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.*;
import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.geminator.generic.*;

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
public class GenericGeminator implements IUnaugmentedTrilateralModifier{

    private Map<String, SubstitutionsApplier> geminators = new HashMap<>();

    public GenericGeminator() {
        //خمس أنواع للادغام للمعلوم والمبني لمجهول في الماضي والمضارع والأمر
        geminators.put(SystemConstants.PAST_TENSE+"true",new ActivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE+"true",new ActivePresentGeminator());
        ImperativeGeminator  imperativeGeminator = new ImperativeGeminator();
        geminators.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE+"true",imperativeGeminator);
        geminators.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE+"true",imperativeGeminator);
        geminators.put(SystemConstants.PAST_TENSE+"false",new PassivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE+"false",new PassivePresentGeminator());
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == KindOfVerb.Mudaaf && (noc == Conjugation.First || noc == Conjugation.Second || noc == Conjugation.Third || noc == Conjugation.Forth || noc == Conjugation.Fifth ) )
                || (kov == KindOfVerb.Mahmouz_Faa_Mudaaf && (noc == Conjugation.First || noc == Conjugation.Second ) )
                || (kov == KindOfVerb.Mithal_Wawi_Mudaaf && noc == Conjugation.Forth)
                || (kov == KindOfVerb.Mithal_Yaee_Mudaaf && (noc == Conjugation.Second || noc == Conjugation.Forth ) );
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        SubstitutionsApplier geminator = geminators.get(tense+active);
        geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
