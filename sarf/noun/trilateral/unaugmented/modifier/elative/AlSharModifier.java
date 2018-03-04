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
public class AlSharModifier {

    public AlSharModifier() {
    }

    public void apply(ConjugationResult conjResult) {
        List conjugations = conjResult.getFinalResult();
        //ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· «·„⁄—¯› »‹ (√·)
        if (ElativeSuffixContainer.getInstance().isDefinite()) {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "«·‘¯Û—¯ı");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "«·‘¯Û—¯Û");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "«·‘¯Û—¯ˆ");
            }
        }
        //- ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· «·„÷«› ≈·Ï „⁄—›…
        // ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· «·„÷«› ≈·Ï ‰ﬂ—…
        else if (ElativeSuffixContainer.getInstance().isAnnexed() || ElativeSuffixContainer.getInstance().isIndefinite()) {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "‘Û—¯ı");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "‘Û—¯Û");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "‘Û—¯ˆ");
            }
        }
        // ÃœÊ·  ’—Ì› «”„ «· ›÷Ì· €Ì— «·„÷«›
        else {
            for (int i=0;i<6; i++) {
                conjugations.set(i, "‘Û—¯Ò");
            }
            for (int i=6;i<12; i++) {
                conjugations.set(i, "‘Û—¯«");
            }
            for (int i=12;i<18; i++) {
                conjugations.set(i, "‘Û—¯Ú");
            }

        }
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == '‘' && root.getC2() == '—' && root.getC3() == '—';
    }
}
