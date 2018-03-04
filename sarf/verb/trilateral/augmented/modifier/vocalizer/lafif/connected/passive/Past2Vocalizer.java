package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

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
        substitutions.add(new InfixSubstitution("öæõ","õ"));// EX: (ÇõÓúæõæÇ¡ ÓõææõæÇ¡ ÇäÛõæõæÇ¡ ÇÓÊõæõæÇ¡ ÊõÓõææõæÇ¡ ÇÓÊõÛúæõæÇ)
        substitutions.add(new InfixSubstitution("øöæõ","øõ"));// EX: (ÓõæøõæÇ¡ ÊõÓõæøõæÇ¡ ÇÍúæõæøõæÇ)
        substitutions.add(new InfixSubstitution("æó","íó"));// EX: (ÃõÓúæöíó¡ Óõæøöíó ÃõÓúæöíóÊú¡ ÃõÓúæöíóÇ¡ Óõææöíó¡ ÇäÛõæöíó¡ ÇÓÊõæöíó¡ ÊõÓõææöíó¡ ÇÓÊõÛúæöíó ÇÍúæõæøöíó)
        substitutions.add(new InfixSubstitution("æú","í"));// EX: (ÃõÓúæöíÊõ¡ ÓõæøöíÊõ ÓõææöíÊõ¡ ÇäÛõæöíÊõ¡ ÇÓÊõæöíÊõ¡ ÊõÓõææöíÊõ¡ ÇÓÊõÛúæöíÊõ)
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
