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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (íõåúÏöí¡ íõÌÇÑöí¡ íóäúËóäöí¡ íóßúÊóİöí¡ íóÓúÊóÛúäöí¡ íóÚúÑóæúÑöí)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íõåúÏö¡ íõÌÇÑö¡ íóäúËóäö¡ íóßúÊóİö¡ íóÓúÊóÛúäö¡ íóÚúÑóæúÑö)
        substitutions.add(new InfixSubstitution("íöä", "ä")); // EX: (ÃäÊö ÊõåúÏöäøó¡ ÊõÌÇÑöäøó¡ ÊóäúËóäöäøó¡ ÊóßúÊóİöäøó¡ ÊóÓúÊóÛúäöäøó¡ ÊóÚúÑóæúÑöäøó)
        substitutions.add(new InfixSubstitution("íöí", "í")); // EX: (ÃäÊö ÊõåúÏöíäó¡ ÊõÌÇÑöíäó¡ ÊóäúËóäöíäó¡ ÊóßúÊóİöíäó¡ ÊóÓúÊóÛúäöíäó¡ ÊóÚúÑóæúÑöíäó)
        substitutions.add(new InfixSubstitution("íúä", "íä")); // EX: (ÃäÊä ÊõåúÏöíäó¡ ÊõÌÇÑöíäó¡ ÊóäúËóäöíäó¡ ÊóßúÊóİöíäó¡ ÊóÓúÊóÛúäöíäó¡ ÊóÚúÑóæúÑöíäó)
        substitutions.add(new InfixSubstitution("öíõæ", "õæ")); // EX: (ÃäÊã ÊõåúÏõæäó¡ ÊõÌÇÑõæäó¡ ÊóäúËóäõæäó¡ ÊóßúÊóİõæäó¡ ÊóÓúÊóÛúäõæäó¡ ÊóÚúÑóæúÑõæäó)
        substitutions.add(new InfixSubstitution("öíõä", "õä")); // EX: (ÃäÊã ÊõåúÏõäøó¡ ÊõÌÇÑõäøó¡ ÊóäúËóäõäøó¡ ÊóßúÊóİõäøó¡ ÊóÓúÊóÛúäõäøó¡ ÊóÚúÑóæúÑõäøó)
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
