package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

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
        substitutions.add(new SuffixSubstitution("íú",""));// EX: (ÃæúÕö¡ æÇáö¡ ÇÊøóŞö¡ ÇÓÊæİö)
        substitutions.add(new InfixSubstitution("íöí","í"));// EX: (ÃäÊö ÃæúÕöí¡ æÇáöí¡ ÇÊøóŞöí¡ ÇÓÊæİöí)
        substitutions.add(new InfixSubstitution("íöä","ä"));// EX: (ÃäÊö ÃæúÕöäøó¡ æÇáöäøó¡ ÇÊøóŞöäøó¡ ÇÓÊæúİöäøó)
        substitutions.add(new InfixSubstitution("íúä","íä"));// EX: (ÃäÊä ÃæúÕöíäó¡ æÇáöíäó¡ ÇÊŞöíäó¡ ÇÓÊóæúİöíäó)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ÃäÊã ÃæúÕõæÇ¡ æÇáõæÇ¡ ÇÊŞõæÇ¡ ÇÓÊæİõæÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 29:
            switch (formulaNo) {
            case 5:
            case 9:
                return true;
            }

        case 30:
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
