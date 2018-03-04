package sarf.verb.trilateral.augmented.modifier.geminator;

import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.*;
import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.geminator.generic.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: «·Õ«·… «·⁄«„… ··«œ€«„  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class GenericGeminator implements IAugmentedTrilateralModifier {

    private Map geminators = new HashMap();

    public GenericGeminator() {
        //Œ„” √‰Ê«⁄ ··«œ€«„ ··„⁄·Ê„ Ê«·„»‰Ì ·„ÃÂÊ· ›Ì «·„«÷Ì Ê«·„÷«—⁄ Ê«·√„—
        geminators.put(SystemConstants.PAST_TENSE + "true", new ActivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE + "true", new ActivePresentGeminator());
        ImperativeGeminator imperativeGeminator = new ImperativeGeminator();
        geminators.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeGeminator);
        geminators.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeGeminator);
        geminators.put(SystemConstants.PAST_TENSE + "false", new PassivePastGeminator());
        geminators.put(SystemConstants.PRESENT_TENSE + "false", new PassivePresentGeminator());
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (formulaNo) {
        case 6:
            switch (kov) {
            case 1:
            case 6:
            case 17:
            case 20:
                return true;
            }
            return false;

        case 12:
            switch (kov) {
            case 1:
            case 11:
            case 17:
            case 20:
                return true;
            }
            return false;
        case 1:
        case 4:
            return kov == 2;

        case 3:
        case 7:
            return kov == 2 || kov == 3 || kov == 8;
        case 5:
        case 9:
            return kov == 2 || kov == 3;
        }
        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        SubstitutionsApplier geminator = (SubstitutionsApplier) geminators.get(tense + active);
        geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
