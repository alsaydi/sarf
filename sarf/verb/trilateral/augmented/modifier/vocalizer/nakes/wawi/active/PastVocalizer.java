package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {
        substitutions.add(new SuffixSubstitution("æó","ì"));// EX: (åæ ÃÏäì¡ Óóãøóì ¡ ÍÇÈì¡ ÇäÌáì¡ ÇÑÊÖì¡ ÇÑÚóæóì¡ ÊÓÇãì¡ ÊÒßøì ¡ ÇÓÊÑÖì¡ ÇÍáæáì)
        substitutions.add(new InfixSubstitution("æúÊ","íúÊ"));// EX: (ÃäÇ ÃÏäóíúÊõ¡ ÓóãøóíúÊõ ¡ ÍÇÈóíúÊõ¡ ÇäÌáíÊõ¡ ÇÑÊÖíÊõ¡ ÇÑÚóæóíúÊõ¡ ÊÓÇãíÊ¡ ÊÒßøóíúÊõ¡  ÇÓÊÑÖíÊ¡ ÇÍáæáíÊõ)
        substitutions.add(new InfixSubstitution("æúä","íúä"));// EX: (ÃäÇ ÃÏäóíúÊõ¡ ÓóãøóíúÊõ ¡ ÍÇÈóíúÊõ¡ ÇäÌáíÊõ¡ ÇÑÊÖíÊõ¡ ÇÑÚóæóíúÊõ¡ ÊÓÇãíÊ¡ ÊÒßøóíúÊõ¡  ÇÓÊÑÖíÊ¡ ÇÍáæáíÊõ)
        substitutions.add(new InfixSubstitution("æõæ", "æú")); // EX: (åã ÃÏäóæúÇ¡ ÓóãøóæúÇ ¡ ÍÇÈóæúÇ¡ ÇäÌóáóæúÇ¡ ÇÑÊÖóæúÇ¡ ÇÑÚóæóæúÇ¡ ÊÓÇãóæúÇ¡ ÊÒßøóæúÇ ¡ ÇÓÊÑÖæÇ¡ ÇÍáæáæÇ)
        substitutions.add(new InfixSubstitution("æóÊ", "Ê")); // EX: (åí ÃÏúäóÊú¡ ÓóãøóÊú ¡ ÍÇÈóÊú¡ ÇäúÌóáóÊú¡ ÇÑÊÖÊ¡ ÇÑúÚóæóÊú¡ ÊÓÇãóÊú¡ ÊÒßøóÊú ¡ ÇÓÊÑÖÊ¡ ÇÍáæáÊ)
        substitutions.add(new InfixSubstitution("æóÇ", "íóÇ")); // EX: (åãÇ ÃÏäóíóÇ¡ ÓóãøóíóÇ ¡ ÍÇÈóíóÇ¡ ÇäúÌóáóíóÇ¡ ÇÑÊÖíÇ¡ ÇÑÚóæóíóÇ¡ ÊÓÇãóíóÇ¡ ÊÒßøóíóÇ ¡ ÇÓÊÑÖíÇ¡ ÇÍáæáíÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if ((kov == 22 || kov == 23) && formulaNo == 4) return true;
        if ((kov == 21 || kov == 23) && (formulaNo == 2 || formulaNo == 9)) return true;
        if (kov == 23 && (formulaNo == 6 || formulaNo == 10)) return true;

        switch (kov) {
        case 21:
        case 22:
        case 23:
            switch (formulaNo) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
                return true;
            }
        }
        return false;
    }
}
