package sarf.verb.quadriliteral.augmented.active.past;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Inject;
import sarf.PastConjugationDataContainer;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.augmented.active.past.formula.AugmentedPastVerb1;
import sarf.verb.quadriliteral.augmented.active.past.formula.AugmentedPastVerb2;
import sarf.verb.quadriliteral.augmented.active.past.formula.AugmentedPastVerb3;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: ?????? ???????</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class QuadrilateralAugmentedActivePastConjugator {
    private final PastConjugationDataContainer pastConjugationDataContainer;

    @Inject
    public QuadrilateralAugmentedActivePastConjugator(PastConjugationDataContainer pastConjugationDataContainer) {
        this.pastConjugationDataContainer = pastConjugationDataContainer;
    }

    public AugmentedPastVerb createVerb(AugmentedQuadrilateralRoot root, int pronounIndex, int formulaNo) {
        String lastDpa = pastConjugationDataContainer.getLastDpa(pronounIndex);
        String connectedPronoun = pastConjugationDataContainer.getConnectedPronoun(pronounIndex);

        switch (formulaNo) {
            case 1:
                return new AugmentedPastVerb1(root, lastDpa, connectedPronoun);
            case 2:
                return new AugmentedPastVerb2(root, lastDpa, connectedPronoun);
            case 3:
                return new AugmentedPastVerb3(root, lastDpa, connectedPronoun);
        }
        return null;
    }

    public List<AugmentedPastVerb> createVerbList(AugmentedQuadrilateralRoot root, int formulaNo) {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createVerb(root, i, formulaNo))
                .collect(Collectors.toList());
    }
}
