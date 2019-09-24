package sarf.noun.trilateral.unaugmented.modifier.elative;

import sarf.verb.trilateral.unaugmented.*;
import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.ConjugationResult;
import sarf.noun.trilateral.unaugmented.elative.*;

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
public class AlSharModifier {

    AlSharModifier() {
    }

    public void apply(ConjugationResult conjResult) {
        List conjugations = conjResult.getFinalResult();
        //جدول تصريف اسم التفضيل المعرّف بـ (أل)
        if (ElativeSuffixContainer.getInstance().isDefinite()) {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "الشَّرُّ");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "الشَّرَّ");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "الشَّرِّ");
            }
        }
        //- جدول تصريف اسم التفضيل المضاف إلى معرفة
        // جدول تصريف اسم التفضيل المضاف إلى نكرة
        else if (ElativeSuffixContainer.getInstance().isAnnexed() || ElativeSuffixContainer.getInstance().isIndefinite()) {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "شَرُّ");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "شَرَّ");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "شَرِّ");
            }
        }
        // جدول تصريف اسم التفضيل غير المضاف
        else {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "شَرٌّ");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "شَرًّا");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "شَرٍّ");
            }

        }
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'ش' && root.getC2() == 'ر' && root.getC3() == 'ر';
    }
}
