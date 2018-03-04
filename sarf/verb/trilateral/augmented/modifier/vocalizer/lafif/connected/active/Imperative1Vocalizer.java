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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {

        substitutions.add(new SuffixSubstitution("íú",""));// EX: (ÃÍúíö¡ ÃĞúæö¡ ÍÇíö¡ ÏÇæö¡ ÇäÒæö¡ ÇÍÊæö¡ ÇÓÊÍíö¡ ÇÓÊåæö)
        substitutions.add(new InfixSubstitution("öíö","ö"));// EX: (ÃäÊö ÃÍúíöí¡ ÃĞúæöí¡ ÍÇíöí¡ ÏÇæöí¡ ÇäÒæöí¡ ÇÍÊæöí¡ ÇÓÊÍíöí¡ ÇÓÊåæöí)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ÃäÊã ÃÍúíõæÇ¡ ÃĞúæõæÇ¡ ÍÇíõæÇ¡ ÏÇæõæÇ¡ ÇäÒæõæÇ¡ ÇÍÊæõæÇ¡ ÇÓÊÍíõæÇ¡ ÇÓÊåæõæÇ)
        substitutions.add(new InfixSubstitution("öíú","öí"));// EX: (ÃäÊä ÃÍúíöíäó¡ ÃĞúæöíäó¡ ÍÇíöíäó¡ ÏÇæöíäó¡ ÇäÒæöíäó¡ ÇÍÊæöíäó¡ ÇÓÊÍíöíäó¡ ÇÓÊåæöíäó)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if ((root.getC2() == 'æ' || root.getC2() == 'í') && root.getC3() == 'í') {
            switch (kov) {
            case 27:
                switch (formulaNo) {
                case 1:
                case 5:
                case 9:
                    return true;
                }

            case 28:
                switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 9:
                    return true;
                }
            }

        }
        return false;
    }
}
