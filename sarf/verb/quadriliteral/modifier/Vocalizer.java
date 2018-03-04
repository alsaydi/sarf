package sarf.verb.quadriliteral.modifier;

import sarf.verb.quadriliteral.ConjugationResult;
import java.util.*;
import sarf.*;
import sarf.verb.quadriliteral.substitution.SubstitutionsApplier;

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
public class Vocalizer {
    //ÇáãÚáæã  æ  ÇáãÌåæá ÊÍÊæí ŞÇÆãÉ ÈÇáÃäæÇÚ ÇáÎãÓÉ áÇÚáÇá áãÇÖí æÇáãÖÇÑÚ æÇáÃãÑ ÍÓÈ
    private Map modifiersMap = new HashMap();

    public Vocalizer() {
        List activePastList = new LinkedList();
        List passivePastList = new LinkedList();
        List activePresentList = new LinkedList();
        List passivePresentList = new LinkedList();
        List imperativeList = new LinkedList();

        //ÎãÓ ÃäæÇÚ  ÃÓÇÓíÉ  ááÇÚáÇá ááãÚáæã æÇáãÈäí áãÌåæá İí ÇáãÇÖí æÇáãÖÇÑÚ æÇáÃãÑ
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //ŞÇÆãÉ ÇáãÇÖí ÇáãÈäí áãÚáæã
        activePastList.add(new sarf.verb.quadriliteral.modifier.vocalizer.nakes.active.PastVocalizer());

        //ŞÇÆãÉ ÇáãÇÖí ÇáãÈäí áãÌåæá
        passivePastList.add(new sarf.verb.quadriliteral.modifier.vocalizer.nakes.passive.PastVocalizer());

        //ŞÇÆãÉ ÇáãÖÇÑÚ ÇáãÈäí áãÚáæã
        activePresentList.add(new sarf.verb.quadriliteral.modifier.vocalizer.nakes.active.Present1Vocalizer());
        activePresentList.add(new sarf.verb.quadriliteral.modifier.vocalizer.nakes.active.Present2Vocalizer());


        //ŞÇÆãÉ ÇáãÖÇÑÚ ÇáãÈäí áãÌåæá
        passivePresentList.add(new sarf.verb.quadriliteral.modifier.vocalizer.nakes.passive.PresentVocalizer());

        //ŞÇÆãÉ ÇáÃãÑ
        imperativeList.add(new sarf.verb.quadriliteral.modifier.vocalizer.nakes.active.Imperative1Vocalizer());
        imperativeList.add(new sarf.verb.quadriliteral.modifier.vocalizer.nakes.active.Imperative2Vocalizer());
    }

    /**
     * ÊØÈíŞ ÇáÇÚáÇá ÍÓÈ ÇáÕíÛÉ ãÇÖí Ãæ ãÖÇÑÚ Ãæ ÃãÑ ááãÚáæã Ãæ áãÌåæá
     * ŞÏ áÇ íØÈŞ Ãí äæÚ ãä ÇáÇÚáÇá
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        List modifiers = (List) modifiersMap.get(tense+active);
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IQuadrilateralModifier modifier = (IQuadrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier)modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
