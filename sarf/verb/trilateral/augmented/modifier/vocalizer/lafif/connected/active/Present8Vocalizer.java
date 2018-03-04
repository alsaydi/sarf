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
public class Present8Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present8Vocalizer() {
        substitutions.add(new SuffixSubstitution("æõ", "í")); // EX: (íõÓóæøöí¡ íóÍúæóæøöí)
        substitutions.add(new SuffixSubstitution("æú", "")); // EX: (áã íõÓóæøö¡ áã íóÍúæóæøö)
        substitutions.add(new InfixSubstitution("æøöæö", "æøö")); // EX: (ÃäÊö ÊõÓóæøöíäó¡ ÊóÍúæóæøöíäó)
        substitutions.add(new InfixSubstitution("øöæó", "øöíó")); // EX: (ÃäÊãÇ ÊõÓóæøöíÇäö¡ ÊóÍúæóæøöíÇäö¡ áä íõÓóæøöíó¡ áä íóÍúæóæøöíó)
        substitutions.add(new InfixSubstitution("øöæõ", "øõ")); // EX: (ÃäÊã ÊõÓóæøõæäó¡ ÊóÍúæóæøõæäó)
        substitutions.add(new InfixSubstitution("øöæú", "øöí")); // EX: (ÃäÊä ÊõÓóæøöíäó¡ ÊóÍúæóæøöíäó)
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
