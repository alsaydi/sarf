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
public class Imperative5Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative5Vocalizer() {
        substitutions.add(new SuffixSubstitution("æú", "")); // EX: (Óóæøö¡ ÇÍúæóæøö)
        substitutions.add(new InfixSubstitution("øöæö", "øö")); // EX: (ÃäÊö Óóæøöí¡ ÇÍúæóæøöí)
        substitutions.add(new InfixSubstitution("øöæó", "øöíó")); // EX: (ÃäÊãÇ ÓóæøöíÇ¡ ÇÍúæóæøöíÇ)
        substitutions.add(new InfixSubstitution("øöæõ", "øõ")); // EX: (ÃäÊã ÓóæøõæÇ¡ ÇÍúæóæøõæÇ)
        substitutions.add(new InfixSubstitution("øöæú", "øöí")); // EX: (ÃäÊä Óóæøöíäó¡ ÇÍúæóæøöíäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'æ' &&  kov == 28 && (formulaNo == 2 || formulaNo == 11);

    }
}
