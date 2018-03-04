package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {

        substitutions.add(new SuffixSubstitution("íú",""));// EX: (ÃåúÏö¡ ÌóÇÑö¡ ÇäúËóäö¡ ÇßúÊóİö¡ ÇÓúÊóÛúäööööööööö¡ ÇÚúÑóæúÑö)
        substitutions.add(new InfixSubstitution("íöí","í"));// EX: (ÃäÊö ÃåúÏöí¡ ÌóÇÑöí¡ ÇäúËóäöí¡ ÇßúÊóİöí¡ ÇÓÊÛúäöí¡ ÇÚúÑóæúÑöí)
        substitutions.add(new InfixSubstitution("íöä","ä"));// EX: (ÃäÊö ÃåúÏöäøó¡ ÌóÇÑöäøó¡ ÇäúËóäöäøó¡ ÇßúÊóİöäøó¡ ÇÓÊÛúäöäøó¡ ÇÚúÑóæúÑöäøó)
        substitutions.add(new InfixSubstitution("íúä","íä"));// EX: (ÃäÊä ÃåúÏöíäó¡ ÌóÇÑöíäó¡ ÇäúËóäöíäó¡ ÇßúÊóİöíäó¡ ÇÓÊÛäöíäó¡ ÇÚúÑóæúÑöí)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ÃäÊã ÃåúÏõæÇ¡ ÌóÇÑõæÇ¡ ÇäúËóäõæÇ¡ ÇßúÊóİõæÇ¡ ÇÓÊÛäõæÇ¡ ÇÚúÑóæúÑõæÇ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 26:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 9:
            case 10:
                return true;
            }

        case 25:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 9:
                return true;
            }

        case 24:
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
