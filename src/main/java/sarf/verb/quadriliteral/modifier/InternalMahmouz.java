package sarf.verb.quadriliteral.modifier;

import sarf.substitution.SubstitutionsApplier;

import java.util.Map;
import java.util.HashMap;
import sarf.SystemConstants;
import sarf.ConjugationResult;

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
public class InternalMahmouz {
    private final Map<String, SubstitutionsApplier> modifiersMap = new HashMap<>();

    InternalMahmouz() {
        modifiersMap.put(SystemConstants.PAST_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.internal.active.PastMahmouz());
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.internal.active.PresentMahmouz());
        modifiersMap.put(SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.internal.active.ImperativeMahmouz());
        modifiersMap.put(SystemConstants.EMPHASIZED_IMPERATIVE_TENSE + "true", new sarf.verb.quadriliteral.modifier.hamza.internal.active.ImperativeMahmouz());
        modifiersMap.put(SystemConstants.PAST_TENSE + "false", new sarf.verb.quadriliteral.modifier.hamza.internal.passive.PastMahmouz());
        modifiersMap.put(SystemConstants.PRESENT_TENSE + "false", new sarf.verb.quadriliteral.modifier.hamza.internal.passive.PresentMahmouz());
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        var modifier = modifiersMap.get(tense + active);
        if (modifier.isApplied(conjResult))
            modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
