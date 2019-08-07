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
        String gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        var gerundDisplayList = createEmptyList();

        //فحص حالة لايعل من الصيغة واحد وتسعة
        if (formulaNo == 1 || formulaNo == 9) {
            boolean applyVocalization = true;
            int result = formulaApplyingChecker.check(root, formulaNo);
            if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
                applyVocalization = false;
            }
            else if (result == IFormulaApplyingChecker.TWO_STATE) {
                if (listener == null) {
                    applyVocalization = true;
                }
                else {
                    //asking the listener to apply or not the vocalization
                    applyVocalization = augmentedTrilateralModifierListener.doSelectVocalization();
                }
            }
            //يؤثر على مواقع التصريف

            if (!applyVocalization) {
                for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
                    if(i == 2){
                        createGerundPattern2(root, gerundDisplayList, i);
                        continue;
                    }
                    else if(i == 3){
                        createGerundPattern3(root, gerundDisplayList, i);
                        continue;
                    }
                    createGerundPatterX(root, gerundPatternClassName, gerundDisplayList, i);
                }
                return gerundDisplayList;
            }
        }

        //normal state

        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            //because index in java start from zero
            Object[] parameters = {root, i + "", genericNounSuffixContainer};
            try {
                TrilateralAugmentedGerund gerund = (TrilateralAugmentedGerund) Class.forName(gerundPatternClassName)
                        .getConstructor(root.getClass(), "".getClass(), genericNounSuffixContainer.getClass()).newInstance(parameters);
                gerundDisplayList.set(i, gerund);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
    }

    private static void createGerundPatterX(AugmentedTrilateralRoot root, String gerundPatternClassName, List<TrilateralAugmentedGerund> gerundDisplayList, int i) {
        //because index in java start from zero
        Object[] parameters = {root, i + ""};
        try {
            TrilateralAugmentedGerund gerund = (TrilateralAugmentedGerund) Class.forName(gerundPatternClassName)
                    .getConstructor(root.getClass(), "".getClass()).newInstance(parameters);
            gerundDisplayList.set(i, gerund);
            ((IChangedGerundPattern) gerund).setForcedForm1Applying(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createGerundPattern3(AugmentedTrilateralRoot root, List<TrilateralAugmentedGerund> gerundDisplayList, int i) {
        var applyForm2 = false;
        if (root.getC1() != 'ي'){
            applyForm2 = selectPatternFormNo(3) == 2;
        }
        var gerund = new GerundPattern3(root, i +"", genericNounSuffixContainer, applyForm2);
        gerundDisplayList.set(i, gerund);
    }

    private void createGerundPattern2(AugmentedTrilateralRoot root, List<TrilateralAugmentedGerund> gerundDisplayList, int i) {
        var applyForm2 = false;
        var applyForm3 = false;
        if (root.getC3() == 'ء') {
           applyForm3 = selectPatternFormNo(2) == 2;

        }
        else if (root.getC3() == 'و' || root.getC3() == 'ي') {
            applyForm2 = true;
        }
        var gerund = new GerundPattern2(root, i +"", genericNounSuffixContainer, applyForm2, applyForm3);
        gerundDisplayList.set(i, gerund);
    }

    //موجودة من أجل صيغة مفاعلة وفعال ليختار أحدهما
    private int selectPatternFormNo(int formulaNo) {
        return listener.selectPatternFormNo(formulaNo);
    }


    public List<TrilateralAugmentedGerund> createEmptyList() {
        return IntStream.rangeClosed(1, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new EmptyGerundPattern(new AugmentedTrilateralRoot(), "0", genericNounSuffixContainer ))
                .collect(Collectors.toList());
    }

    public void setListener(TrilateralAugmentedGerundConjugatorListener listener) {
        this.listener = listener;
    }

    public void setAugmentedTrilateralModifierListener(AugmentedTrilateralModifierListener augmentedTrilateralModifierListener) {
        this.augmentedTrilateralModifierListener = augmentedTrilateralModifierListener;
    }
}
