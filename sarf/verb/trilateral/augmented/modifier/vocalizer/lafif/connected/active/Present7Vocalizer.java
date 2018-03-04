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
public class Present7Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present7Vocalizer() {
        substitutions.add(new SuffixSubstitution("æõ", "í")); // EX: (íõÓúæöí¡ íõÓÇæöí¡ ÊäÛæí¡ íÓÊæí¡ íÓÊÛæí)
        substitutions.add(new SuffixSubstitution("æú", "")); // EX: (áã íõÓúæö¡ áã íõÓÇæö¡ áã íäÛæö¡ áã íóÓÊæö¡ áã íÓÊÛæö)
        substitutions.add(new InfixSubstitution("æöæö", "æö")); // EX: (ÃäÊö ÊõÓúæöíäó¡ ÊõÓÇæöíäó¡ ÊäÛæíä¡ ÊÓÊæíä¡ ÊÓÊÛæíä)
        substitutions.add(new InfixSubstitution("öæó", "öíó")); // EX: (ÃäÊãÇ ÊõÓúæöíóÇäö¡ ÊõÓÇæöíÇäö¡ ÊäÛæíÇä¡ ÊÓÊæíÇä¡ ÊÓÊÛæíÇä)
        substitutions.add(new InfixSubstitution("öæõ", "õ")); // EX: (ÃäÊã ÊõÓúæõæäó¡ ÊõÓÇæõæäó¡ ÊäÛæõæäó¡ ÊÓÊæõæäó¡ ÊÓÊÛææä)
        substitutions.add(new InfixSubstitution("öæú", "öí")); // EX: (ÃäÊä ÊõÓúæöíäó¡ ÊõÓÇæöíäó¡ ÊäÛæíä¡ ÊÓÊæíä¡ ÊÓÊÛæíä)
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
            case 3:
            case 4:
            case 5:
            case 9:
                return true;
            }
        }
        return false;
    }
}
