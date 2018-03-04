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
public class Imperative4Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative4Vocalizer() {
        substitutions.add(new SuffixSubstitution("æú",""));// EX: (ÃÓúæö¡ ÓÇæö¡ ÇäúÛóæö¡ ÇÓÊóæö¡ ÇÓÊóÛúæö)
        substitutions.add(new InfixSubstitution("öæö","ö"));// EX: (ÃäÊö ÃÓúæöí¡ ÓÇæöí¡ ÇäúÛóæöí¡ ÇÓÊóæöí¡ ÇÓÊóÛúæöí)
        substitutions.add(new InfixSubstitution("öæó","öíó"));// EX: (ÃäÊãÇ ö ÃÓúæöíÇ¡ ÓÇæöíÇ¡ ÇäúÛóæöíÇ¡ ÇÓÊóæöíÇ¡ ÇÓÊóÛúæöíÇ)
        substitutions.add(new InfixSubstitution("öæõ","õ"));// EX: (ÃäÊã ÃÓúæõæÇ¡ ÓÇæõæÇ¡ ÇäúÛóæõæÇ¡ ÇÓÊóæõæÇ¡ ÇÓÊóÛúæõæÇ)
        substitutions.add(new InfixSubstitution("öæú","öí"));// EX: (ÃäÊä ÃÓúæöíäó¡ ÓÇæöíäó¡ ÇäúÛóæöíäó¡ ÇÓÊóæöíäó¡ ÇÓÊóÛúæöíäó)
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
