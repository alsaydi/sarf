package sarf.verb.trilateral.augmented.modifier;

import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.pre.vocalizer.*;
import sarf.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: Ìÿ»ﬁ ﬁ»· «·«⁄·«· ﬂ„—Õ·… √Ê·Ï ›Ì «·≈⁄·«·      </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PreVocalizer {

    private SeparatedLafifActivePresentVocalizer separatedLafifActivePresentVocalizer = new SeparatedLafifActivePresentVocalizer();
    private SeparatedLafifPassivePresentVocalizer separatedLafifPassivePresentVocalizer = new SeparatedLafifPassivePresentVocalizer();
    private SeparatedLafifPassviePastVocalizer separatedLafifPassivePastVocalizer = new SeparatedLafifPassviePastVocalizer();

    public PreVocalizer() {
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        if (active) {
            if (tense.equals(SystemConstants.PRESENT_TENSE) && separatedLafifActivePresentVocalizer.isApplied(conjResult))
                separatedLafifActivePresentVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        }
        else {
            if (tense.equals(SystemConstants.PRESENT_TENSE) && separatedLafifPassivePresentVocalizer.isApplied(conjResult))
                separatedLafifPassivePresentVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
            else if (tense.equals(SystemConstants.PAST_TENSE) && separatedLafifPassivePastVocalizer.isApplied(conjResult))
                separatedLafifPassivePastVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        }

    }

}
