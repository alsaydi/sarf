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

    private Map geminators = new HashMap();

    public GenericGeminator() {
        //Œ„” √‰Ê«⁄ ··«œ€«„ ··„⁄·Ê„ Ê«·„»‰Ì ·„ÃÂÊ· ›Ì «·„«÷Ì Ê«·„÷«—⁄ Ê«·√„—
        geminators.put(SystemConstants.PAST_TENSE+"true",new ActivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE+"true",new ActivePresentGeminator());
        ImperativeGeminator  imperativeGeminator = new ImperativeGeminator();
        geminators.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE+"true",imperativeGeminator);
        geminators.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE+"true",imperativeGeminator);
        geminators.put(SystemConstants.PAST_TENSE+"false",new PassivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE+"false",new PassivePresentGeminator());
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 2 && (noc == 1 || noc == 2 || noc == 3 || noc == 4 || noc == 5 ) )
                || (kov == 3 && (noc == 1 || noc == 2 ) )
                || (kov == 8 && noc == 4)
                || (kov == 12 && (noc == 2 || noc == 4 ) );
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        SubstitutionsApplier geminator = (SubstitutionsApplier) geminators.get(tense+active);
        geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
