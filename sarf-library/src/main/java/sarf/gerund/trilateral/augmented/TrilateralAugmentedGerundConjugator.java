package sarf.gerund.trilateral.augmented;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.modifier.vocalizer.*;
import sarf.gerund.trilateral.augmented.pattern.*;

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
public class TrilateralAugmentedGerundConjugator {
    private final FormulaApplyingChecker formulaApplyingChecker;
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    private TrilateralAugmentedGerundConjugatorListener listener;
    private AugmentedTrilateralModifierListener augmentedTrilateralModifierListener;

    @Inject
    public TrilateralAugmentedGerundConjugator(FormulaApplyingChecker formulaApplyingChecker
            , GenericNounSuffixContainer genericNounSuffixContainer) {
        this.formulaApplyingChecker = formulaApplyingChecker;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    public List<TrilateralAugmentedGerund> createGerundList(AugmentedTrilateralRoot root, int formulaNo) {
        var gerundDisplayList = createEmptyList();
        var applyVocalization = false; /* إعلال المصدر أم لا */

        //فحص حالة لايعل من الصيغة واحد وتسعة
        if (formulaNo == 1 || formulaNo == 9) {
            applyVocalization = true;
            var result = formulaApplyingChecker.check(root, formulaNo);
            if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
                applyVocalization = false;
            } else if (result == IFormulaApplyingChecker.TWO_STATE && listener != null) {
                //asking the listener to apply or not the vocalization
                applyVocalization = augmentedTrilateralModifierListener.doSelectVocalization();
            }
        }

        //normal state
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            var gerund = createGerundPatterX(root, i, formulaNo, applyVocalization);
            gerundDisplayList.set(i, gerund);

            if(!applyVocalization && gerund instanceof IChangedGerundPattern){
                ((IChangedGerundPattern) gerund).setForcedForm1Applying(true);
            }
        }
        return gerundDisplayList;
    }

    private TrilateralAugmentedGerund createGerundPatterX(AugmentedTrilateralRoot root, int suffix, int formula, boolean applyVocalization) {
        //because index in java start from zero
        switch (formula) {
            case 1:
                return new GerundPattern1(root, suffix + "", genericNounSuffixContainer);
            case 2:
                return !applyVocalization ? createGerundPattern2(root, suffix + "") : new GerundPattern2(root, suffix + "", genericNounSuffixContainer);
            case 3:
                return !applyVocalization ? createGerundPattern3(root, suffix + "") : new GerundPattern3(root, suffix + "", genericNounSuffixContainer);
            case 4:
                return new GerundPattern4(root, suffix + "", genericNounSuffixContainer);
            case 5:
                return new GerundPattern5(root, suffix + "", genericNounSuffixContainer);
            case 6:
                return new GerundPattern6(root, suffix + "", genericNounSuffixContainer);
            case 7:
                return new GerundPattern7(root, suffix + "", genericNounSuffixContainer);
            case 8:
                return new GerundPattern8(root, suffix + "", genericNounSuffixContainer);
            case 9:
                return new GerundPattern9(root, suffix + "", genericNounSuffixContainer);
            case 10:
                return new GerundPattern10(root, suffix + "", genericNounSuffixContainer);
            case 11:
                return new GerundPattern11(root, suffix + "", genericNounSuffixContainer);
            case 12:
                return new GerundPattern12(root, suffix + "", genericNounSuffixContainer);
        }
        return new EmptyGerundPattern(root, "0", genericNounSuffixContainer);
    }

    private GerundPattern2 createGerundPattern2(AugmentedTrilateralRoot root, String suffix) {
        var applyForm2 = false;
        var applyForm3 = false;
        if (root.getC3() == 'ء') {
            applyForm3 = selectPatternFormNo(2) == 2;

        } else if (root.getC3() == 'و' || root.getC3() == 'ي') {
            applyForm2 = true;
        }
        return new GerundPattern2(root, suffix, genericNounSuffixContainer, applyForm2, applyForm3);
    }

    private GerundPattern3 createGerundPattern3(AugmentedTrilateralRoot root, String suffix) {
        var applyForm2 = false;
        if (root.getC1() != 'ي') {
            applyForm2 = selectPatternFormNo(3) == 2;
        }
        return new GerundPattern3(root, suffix, genericNounSuffixContainer, applyForm2);
    }

    //موجودة من أجل صيغة مفاعلة وفعال ليختار أحدهما
    private int selectPatternFormNo(int formulaNo) {
        if (listener == null)
            return 1;
        return listener.selectPatternFormNo(formulaNo);
    }

    private List<TrilateralAugmentedGerund> createEmptyList() {
        return IntStream.rangeClosed(1, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new EmptyGerundPattern(new AugmentedTrilateralRoot(), "0", genericNounSuffixContainer))
                .collect(Collectors.toList());
    }

    public void setListener(TrilateralAugmentedGerundConjugatorListener listener) {
        this.listener = listener;
    }

    public void setAugmentedTrilateralModifierListener(AugmentedTrilateralModifierListener augmentedTrilateralModifierListener) {
        this.augmentedTrilateralModifierListener = augmentedTrilateralModifierListener;
    }
}
