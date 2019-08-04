package sarf.gerund.trilateral.augmented.nomen;

import com.google.inject.Inject;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPatternEmpty;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.*;
import java.util.*;

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
public class TrilateralAugmentedNomenGerundConjugator {
    private final int[] indexArray = {2, 4, 6, 8, 10, 12, 14, 16, 18};
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public TrilateralAugmentedNomenGerundConjugator(GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<TrilateralAugmentedNomenGerund> createGerundList(AugmentedTrilateralRoot root, int formulaNo) {
        var gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        var gerundDisplayList = createEmptyList();

        for (int value : indexArray) {
            //because index in java start from zero
            int suffixNo = value - 1;
            Object[] parameters = {root, suffixNo + "", genericNounSuffixContainer};
            try {
                TrilateralAugmentedNomenGerund gerund = (TrilateralAugmentedNomenGerund) Class.forName(gerundPatternClassName)
                        .getConstructor(root.getClass(), "".getClass(), genericNounSuffixContainer.getClass())
                        .newInstance(parameters);
                gerundDisplayList.set(suffixNo, gerund);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
    }

    private List<TrilateralAugmentedNomenGerund> createEmptyList() {
        var result = new ArrayList<TrilateralAugmentedNomenGerund>(18);
        for (int i = 1; i <= 18; i++) {
            result.add(new GerundPatternEmpty(new AugmentedTrilateralRoot(), "0", genericNounSuffixContainer));
        }
        return result;
    }

}
