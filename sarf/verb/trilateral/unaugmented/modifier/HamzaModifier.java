package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import java.util.Map;
import java.util.HashMap;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.SystemConstants;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

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
public class HamzaModifier {
    private Map modifiersMap = new HashMap();

    public HamzaModifier() {
        List activePastList = new LinkedList();
        List passivePastList = new LinkedList();
        List activePresentList = new LinkedList();
        List passivePresentList = new LinkedList();
        List imperativeList = new LinkedList();
        List emphasizedImperativeList = new LinkedList();

        //Œ„” √‰Ê«⁄  √”«”Ì…  ··„Â„Ê“ ··„⁄·Ê„ Ê«·„»‰Ì ·„ÃÂÊ· ›Ì «·„«÷Ì Ê«·„÷«—⁄ Ê«·√„—
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", activePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", activePresentList);
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", imperativeList);
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", emphasizedImperativeList);
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", passivePastList);
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", passivePresentList);

        //ﬁ«∆„… «·„«÷Ì «·„»‰Ì ·„⁄·Ê„
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.ActivePastMahmouz());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.ActivePastMahmouz());
        activePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ActivePastMahmouz());

        //ﬁ«∆„… «·„«÷Ì «·„»‰Ì ·„ÃÂÊ·
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.PassivePastMahmouz());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.PassivePastMahmouz());
        passivePastList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.PassivePastMahmouz());


        //ﬁ«∆„… «·„÷«—⁄ «·„»‰Ì ·„⁄·Ê„
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.RaaPresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.ActivePresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.ActivePresentMahmouz());
        activePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ActivePresentMahmouz());

        //ﬁ«∆„… «·„÷«—⁄ «·„»‰Ì ·„ÃÂÊ·
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.RaaPresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.PassivePresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.PassivePresentMahmouz());
        passivePresentList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.PassivePresentMahmouz());

        //ﬁ«∆„… «·√„—
        //Ê÷⁄ «·Õ«·«  «·Œ«’… √Ê·«
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.RaaImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialImperativeMahmouz1());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialImperativeMahmouz2());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.SpecialImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.ImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.ImperativeMahmouz());
        imperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.lam.ImperativeMahmouz());

        //ﬁ«∆„… «·√„— «·„ƒﬂœ
        emphasizedImperativeList.add(imperativeList.get(0));
        emphasizedImperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialEmphsizedImperativeMahmouz1());
        emphasizedImperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.faa.SpecialEmphsizedImperativeMahmouz2());
        emphasizedImperativeList.add(new sarf.verb.trilateral.unaugmented.modifier.hamza.ein.SpecialEmphsizedImperativeMahmouz());
        emphasizedImperativeList.add(imperativeList.get(4));
        emphasizedImperativeList.add(imperativeList.get(5));
        emphasizedImperativeList.add(imperativeList.get(6));
    }

    /**
     *  ÿ»Ìﬁ  €ÌÌ—  «·Â„“… Õ”» «·’Ì€… „«÷Ì √Ê „÷«—⁄ √Ê √„— ··„⁄·Ê„ √Ê ·„ÃÂÊ·
     * ﬁœ ·« Ìÿ»ﬁ √Ì ‰Ê⁄
     * @param tense String
     * @param active boolean
     * @param conjResult ConjugationResult
     */
    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        List modifiers = (List) modifiersMap.get(tense+active);
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IUnaugmentedTrilateralModifier modifier = (IUnaugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier)modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
