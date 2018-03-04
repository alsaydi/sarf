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
public class Past3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past3Vocalizer() {

        substitutions.add(new SuffixSubstitution("óæó","óì"));// EX: (ÃÓæóì¡ Óóæøóì ÓÇæóì¡ ÇäÛæì¡ ÇÓÊæì¡ ÊÓÇæì¡ ÊóÓóæøóì ÇÓÊÛæì ÇÍúæóæøóì)
        substitutions.add(new InfixSubstitution("æú","íú"));// EX: (ÃÓúæóíúÊõ¡ ÓóæøóíúÊõ ÓÇæóíúÊõ¡ ÇäÛæíÊõ¡ ÇÓÊæóíúÊõ¡ ÊÓÇæíÊõ¡ ÊÓæøóíúÊõ ÇÓÊÛæóíúÊõ ÇÍæóæøóíúÊõ)
        substitutions.add(new InfixSubstitution("æóÇ","íóÇ"));// EX: (ÃÓúæóíóÇ¡ ÓóæøóíÇ ÓÇæóíÇ¡ ÇäÛæíÇ¡ ÇÓÊæóíÇ¡ ÊÓÇæóíóÇ¡ ÊóÓóæøóíóÇ¡ ÇÓÊÛæóíóÇ¡ ÇÍúæóæøóíóÇ)
        substitutions.add(new InfixSubstitution("æõæ","æú"));// EX: (ÃÓúæóæúÇ¡ ÓóæøóæúÇ ÓÇæóæúÇ¡ ÇäÛæóæúÇ¡ ÇÓÊæóæúÇ¡ ÊÓÇæóæúÇ¡ ÊóÓóæøóæúÇ¡ ÇÓÊÛæóæúÇ¡ ÇÍúæóæøóæúÇ)
        substitutions.add(new InfixSubstitution("æóæó","æó"));// EX: (ÃÓúæóÊú¡ )
        substitutions.add(new InfixSubstitution("æøóæó","æøó"));// EX: (ÓóæøóÊú¡ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'æ' && kov == 28) {
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
                return true;
            }
        }
        return false;
    }
}
