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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("óíõ","óÇ"));// EX: (íõÍúíóÇ¡ íÍíøóÇ¡ íÍÇíóÇ¡ íÒÏíóÇ¡ íÊÍóÇíóÇ¡ íÊÍíøóÇ¡ íõÓÊÍíóÇ)
        substitutions.add(new SuffixSubstitution("óíó","óÇ"));// EX: (áä íõÍúíóÇ¡ íÍíøóÇ¡ íÍÇíóÇ¡ íÒÏíóÇ¡ íÊÍóÇíóÇ¡ íÊÍíøóÇ¡ íõÓÊÍíóÇ)
        substitutions.add(new SuffixSubstitution("íú",""));// EX: (áã íõÍúíó¡ íÍíøó¡ íÍÇíó¡ íÒÏíó¡ íÊÍóÇíó¡ íÊÍíøó¡ íõÓÊÍíó)
        substitutions.add(new InfixSubstitution("íöí","íú"));// EX: (ÃäÊö ÊõÍúíóíúäó¡ ÊõÍóíøóíúäó¡ ÊÍÇíóíúäó¡ ÊÒÏíóíúäó¡ ÊÊÍÇíóíúäó¡ ÊÊÍíøóíúäó¡ ÊÓÊÍíóíúäó)
        substitutions.add(new InfixSubstitution("íõæ","æú"));// EX: (ÃäÊã ÊõÍúíóæúäó¡ ÊõÍóíøóæúäó¡ ÊõÍÇíóæúäó¡ ÊÒÏóíóæúäó¡ ÊÊÍÇíóæúäó¡ ÊÊÍíøóæúäó¡ ÊÓÊÍíóæúäó)
        substitutions.add(new InfixSubstitution("íõä","æõä"));// EX: (ÃäÊã ÊõÍúíóæõäøó¡ ÊõÍóíøóæõäøó¡ ÊÍÇíóæõäøó ÊÒÏíóæõäøó¡ ÊõÊóÍóÇíóæõäøó¡ ÊõÊóÍóíøóæõäøó¡ ÊÓÊÍíóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'í' && kov == 28) {
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }
        }

        return false;
    }
}
