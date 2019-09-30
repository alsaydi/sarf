package sarf.verb.trilateral.augmented.active.present;

import sarf.PresentConjugationDataContainer;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.AugmentedPresentVerb;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb1;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb10;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb11;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb12;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb2;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb3;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb4;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb5;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb6;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb7;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb8;
import sarf.verb.trilateral.augmented.active.present.formula.AugmentedPresentVerb9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public final class AugmentedPresentConjugator {
    private final List<String> lastDprList;
    private final List<String> connectedPronounList;

    AugmentedPresentConjugator(List<String> lastDprList, List<String> connectedPronounList) {
        this.lastDprList = lastDprList;
        this.connectedPronounList = connectedPronounList;
    }

    private AugmentedPresentVerb createVerb(AugmentedTrilateralRoot root, int pronounIndex, int formulaNo) {
        String cp = PresentConjugationDataContainer.getCp(pronounIndex);
        String lastDpr = lastDprList.get(pronounIndex);
        String connectedPronoun = connectedPronounList.get(pronounIndex);
        switch (formulaNo) {
            case 1:
                return new AugmentedPresentVerb1(root, cp, lastDpr, connectedPronoun);
            case 2:
                return new AugmentedPresentVerb2(root, cp, lastDpr, connectedPronoun);
            case 3:
                return new AugmentedPresentVerb3(root, cp, lastDpr, connectedPronoun);
            case 4:
                return new AugmentedPresentVerb4(root, cp, lastDpr, connectedPronoun);
            case 5:
                return new AugmentedPresentVerb5(root, cp, lastDpr, connectedPronoun);
            case 6:
                return new AugmentedPresentVerb6(root, cp, lastDpr, connectedPronoun);
            case 7:
                return new AugmentedPresentVerb7(root, cp, lastDpr, connectedPronoun);
            case 8:
                return new AugmentedPresentVerb8(root, cp, lastDpr, connectedPronoun);
            case 9:
                return new AugmentedPresentVerb9(root, cp, lastDpr, connectedPronoun);
            case 10:
                return new AugmentedPresentVerb10(root, cp, lastDpr, connectedPronoun);
            case 11:
                return new AugmentedPresentVerb11(root, cp, lastDpr, connectedPronoun);
            case 12:
                return new AugmentedPresentVerb12(root, cp, lastDpr, connectedPronoun);
        }
        return null;
    }

    public List<AugmentedPresentVerb> createVerbList(AugmentedTrilateralRoot root, int formulaNo) {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> createVerb(root, i, formulaNo))
                .collect(Collectors.toList());
    }
}
