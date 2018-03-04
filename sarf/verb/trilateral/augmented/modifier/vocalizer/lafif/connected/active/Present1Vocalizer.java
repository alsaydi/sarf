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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (íõÍúíöí¡ íÍÇíöí¡ íÒÏíí¡ íÓÊÍíí)
        substitutions.add(new SuffixSubstitution("öíú","ö"));// EX: (áã íõÍúíö¡ áã íõÍÇíö¡ áã íóÒÏóíö¡ áã íóÓúÊóÍöí)
        substitutions.add(new InfixSubstitution("öíöí","öí"));// EX: (ÃäÊö ÊõÍúíöíäó¡ ÊõÍÇíöíäó¡ ÊÒÏííä¡ ÊÓÊÍííä)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ÃäÊã ÊõÍúíõæä¡ ÊõÍÇíõæä¡ ÊÒÏíæä¡ ÊÓÊÍíæä)
        substitutions.add(new InfixSubstitution("öíú","öí"));// EX: (ÃäÊä ÊõÍúíöíäó¡ ÊõÍÇíöíä¡ ÊÒÏííä¡ ÊÓÊÍííä)
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
            case 3:
            case 5:
            case 9:
                return true;
            }
        }
        return false;
    }
}
