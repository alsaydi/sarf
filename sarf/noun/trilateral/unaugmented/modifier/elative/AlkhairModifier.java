package sarf.noun.trilateral.unaugmented.modifier.elative;

import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.elative.hamza.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
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
public class AlkhairModifier {

    public AlkhairModifier() {
    }

    public void apply(ConjugationResult conjResult) {
        List conjugations = conjResult.getFinalResult();
        //ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· «·„⁄—¯› »‹ (√·)
        if (ElativeSuffixContainer.getInstance().isDefinite()) {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "«·˙ŒÛÌ˙—ı");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "«·˙ŒÛÌ˙—Û");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "«·˙ŒÛÌ˙—ˆ");
            }
        }
        //- ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· «·„÷«› ≈·Ï „⁄—›…
        // ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· «·„÷«› ≈·Ï ‰ﬂ—…
        else if (ElativeSuffixContainer.getInstance().isAnnexed() || ElativeSuffixContainer.getInstance().isIndefinite()) {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "ŒÛÌ˙—ı");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "ŒÛÌ˙—Û");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "ŒÛÌ˙—ˆ");
            }
        }
        // ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· €Ì— «·„÷«›
        else {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "ŒÛÌ˙—Ò");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "ŒÛÌ˙—«");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "ŒÛÌ˙—Ú");
            }

        }
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'Œ' && root.getC2() == 'Ì' && root.getC3() == '—';
    }
}
