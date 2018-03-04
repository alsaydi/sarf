package sarf.verb.trilateral.unaugmented.modifier.geminator;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.SystemConstants;
import sarf.verb.trilateral.unaugmented.modifier.geminator.ngeminator.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:
 * «·«œ€«„ ··„‰ ÂÌ »«·‰Ê‰ ÂÊ ‰›”Â „‰ √Ã· ﬂ· «·’Ì€ ··„⁄·Ê„ Ê··„ÃÂÊ·
 * Ê·ﬂ‰  Œ ·› ›Ì„« »Ì‰Â« »√—ﬁ«„ «·÷„«∆—
 * ›ÂÊ «·’› «·√» ··À·«À «·’›Ê› ›Ì «·„«÷Ì Ê«·„÷«—⁄ Ê«·√„—
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

    private List substitutions = new LinkedList();
    //√—ﬁ«„ «·÷„«∆— «· Ì Ì„ﬂ‰ «· ÿ»Ìﬁ „‰ √Ã·Â« Õ”» «·’Ì€……  „«÷Ì √Ê „÷«—⁄ √Ê √„—
    private Map indeciesMap = new HashMap();

    public NGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("‰˙‰Û","‰¯Û"));

        List indecies = new ArrayList(2);
        indecies.add("2");
        indecies.add("13");
        indeciesMap.put(SystemConstants.PAST_TENSE, indecies);

        indecies = new ArrayList(2);
        indecies.add("7");
        indecies.add("13");
        indeciesMap.put(SystemConstants.PRESENT_TENSE, indecies);

        indecies = new ArrayList(1);
        indecies.add("7");
        indeciesMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, indecies);
        indeciesMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, indecies);
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        return (conjugationResult.getRoot().getC3()=='‰' && (kov == 1 || kov == 2 || kov == 3 || kov == 5 || kov == 6 || kov == 11 || kov == 14 || kov == 15 || kov == 17 || kov == 18 || kov == 20));
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        //it is the same active or passive
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    /*protected List getAppliedPronounsIndecies(String tense) {
        return (List) indeciesMap.get(tense);
    }*/
}
