package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.*;

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
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past2Vocalizer() {
        substitutions.add(new SuffixSubstitution("íó","ì"));// EX: (ÃĞúæóì¡ Şóæøóì¡ ÏÇæì¡ ÇäÒæì¡ ÇÍÊæì¡ÊÏÇæì¡ ÊŞæøóì ÇÓÊåæì)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃĞæóæúÇ¡ ŞóæøóæúÇ ÏÇæóæúÇ¡ ÇäÒóæóæúÇ¡ ÇÍÊóæóæúÇ¡ ÊÏÇæóæúÇ¡ ÊóŞóæøóæúÇ¡ ÇÓÊåæóæúÇ)
        substitutions.add(new InfixSubstitution("íóÊ", "Ê")); // EX: (ÃĞæóÊú¡ ŞóæøóÊ ÏÇæóÊ¡ ÇäÒæÊú¡ ÇÍÊæÊú¡ ÊÏÇæÊú¡ ÊŞæøóÊú¡ ÇÓÊåæÊú)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == 'æ' && root.getC3() == 'í') {
            switch (kov) {
            case 27:
                switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
                }

            case 28:
                switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
                }
            }
        }
        return false;
    }
}
