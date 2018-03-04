package sarf.gerund.trilateral.augmented;

import java.util.*;

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
    private static TrilateralAugmentedGerundConjugator instance = new TrilateralAugmentedGerundConjugator();
    private Map gerundClassMap = new HashMap();
    private TrilateralAugmentedGerundConjugatorListener listener;

    private AugmentedTrilateralModifierListener augmentedTrilateralModifierListener;

    private TrilateralAugmentedGerundConjugator() {
        for (int i = 1; i <= 12; i++) {
            String gerundClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + i;
            try {
                Class gerundClass = Class.forName(gerundClassName);
                gerundClassMap.put(i + "", gerundClass.newInstance());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static TrilateralAugmentedGerundConjugator getInstance() {
        return instance;
    }

    public List createGerundList(AugmentedTrilateralRoot root, int formulaNo) {
        String gerundPatternClassName = getClass().getPackage().getName() + ".pattern." + "GerundPattern" + formulaNo;
        List gerundDisplayList = createEmptyList();

        TrilateralAugmentedGerund gerundInstance = (TrilateralAugmentedGerund) gerundClassMap.get(formulaNo + "");

        //ÝÍÕ ÍÇáÉ áÇíÚá ãä ÇáÕíÛÉ æÇÍÏ æÊÓÚÉ
        if (formulaNo == 1 || formulaNo == 9) {
            boolean applyVocalization = true;
            int result = FormulaApplyingChecker.getInstance().check(root, formulaNo);
            if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
                applyVocalization = false;
            }
            else if (result == IFormulaApplyingChecker.TWO_STATE) {
                if (listener == null) {
                    applyVocalization = true;
                }
                else {
                    //asking the listener to apply or not the vocaliztion
                    applyVocalization = augmentedTrilateralModifierListener.doSelectVocalization();
                }
            }
            //íÄËÑ Úáì ãæÇÞÚ ÇáÊÕÑíÝ

            if (!applyVocalization) {
                for (int i = 0; i < 18; i++) {
                    //because index in java start from zero
                    Object[] parameters = {root, i + ""};
                    try {
                        TrilateralAugmentedGerund gerund = (TrilateralAugmentedGerund) Class.forName(gerundPatternClassName).getConstructors()[0].newInstance(parameters);
                        gerundDisplayList.set(i, gerund);
                        ((IChangedGerundPattern)gerund).setForcedForm1Applying(true);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return gerundDisplayList;
            }
        }

        //normal state

        for (int i = 0; i < 18; i++) {
            //because index in java start from zero
            Object[] parameters = {root, i + ""};
            try {
                TrilateralAugmentedGerund gerund = (TrilateralAugmentedGerund) Class.forName(gerundPatternClassName).getConstructors()[0].newInstance(parameters);
                gerundDisplayList.set(i, gerund);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return gerundDisplayList;
    }


    //ãæÌæÏÉ ãä ÃÌá ÕíÛÉ ãÝÇÚáÉ æÝÚÇá áíÎÊÇÑ ÃÍÏåãÇ
    public int selectPatternFormNo(int formulaNo) {
        return listener.selectPatternFormNo(formulaNo);
    }


    public List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

    public void setListener(TrilateralAugmentedGerundConjugatorListener listener) {
        this.listener = listener;
    }

    public void setAugmentedTrilateralModifierListener(AugmentedTrilateralModifierListener augmentedTrilateralModifierListener) {
        this.augmentedTrilateralModifierListener = augmentedTrilateralModifierListener;
    }

}
