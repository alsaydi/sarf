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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (íõÍóíøöí)
        substitutions.add(new SuffixSubstitution("íú",""));// EX: (áã íõÍóíøö)
        substitutions.add(new InfixSubstitution("øöíö","øö"));// EX: (ÃäÊö ÊõÍóíøöíäó)
        substitutions.add(new InfixSubstitution("øöíõ","øõ"));// EX: (ÃäÊã ÊõÍóíøõæäó)
        substitutions.add(new InfixSubstitution("øöíú","øöí"));// EX: (ÃäÊä ÊõÍóíøöíäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'í' && kov == 28 && formulaNo == 2;
    }
}
