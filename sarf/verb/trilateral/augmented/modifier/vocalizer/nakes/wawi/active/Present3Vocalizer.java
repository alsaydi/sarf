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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("æõ", "í")); // EX: (åæ íõÓóãøöí)
        substitutions.add(new SuffixSubstitution("æú", "")); // EX: (áã íõÓóãøö)
        substitutions.add(new InfixSubstitution("øöæõ", "øõ")); // EX: (ÃäÊã ÊõÓóãøõæäó)
        substitutions.add(new InfixSubstitution("æúä", "íä")); // EX: (ÃäÊä ÊõÓóãøöíäó)
        substitutions.add(new InfixSubstitution("æó", "íó")); // EX: (áä íõÓóãøöíó)
        substitutions.add(new InfixSubstitution("æö", "")); // EX: (ÃäÊö ÊõÓóãøöíäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 21 || kov == 23) && formulaNo == 2;
    }
}
