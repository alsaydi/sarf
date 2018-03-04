package sarf.verb.quadriliteral.modifier;

import sarf.verb.quadriliteral.*;
import sarf.verb.quadriliteral.substitution.*;
import java.util.Map;
import java.util.HashMap;
import sarf.SystemConstants;

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
public class EndedMahmouz {
    private Map modifiersMap = new HashMap();

    public EndedMahmouz() {
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.ended.active.PastMahmouz());
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.ended.active.PresentMahmouz());
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.ended.active.ImperativeMahmouz());
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.ended.active.ImperativeMahmouz());
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", new sarf.verb.quadriliteral.modifier.hamza.ended.passive.PastMahmouz());
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", new sarf.verb.quadriliteral.modifier.hamza.ended.passive.PresentMahmouz());
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        if (conjResult.getRoot().getC4() != 'Á') {
            return;
        }

        SubstitutionsApplier modifier = (SubstitutionsApplier) modifiersMap.get(tense + active);
        modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

}
