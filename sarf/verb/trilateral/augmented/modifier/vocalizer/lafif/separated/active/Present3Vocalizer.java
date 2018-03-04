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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (íõæóÕøöí)
        substitutions.add(new SuffixSubstitution("íú",""));// EX: (áã íõæóÕøö)
        substitutions.add(new InfixSubstitution("íöä","ä"));// EX: (ÃäÊö ÊõæóÕøöäøó)
        substitutions.add(new InfixSubstitution("íöí","í"));// EX: (ÃäÊö ÊõæóÕøöíäó)
        substitutions.add(new InfixSubstitution("íúä","íä"));// EX: (ÃäÊä ÊõæóÕøöíäó)
        substitutions.add(new InfixSubstitution("øöíõæ","øõæ"));// EX: (ÃäÊã ÊõæóÕøõæäó)
        substitutions.add(new InfixSubstitution("øöíõä","øõä"));// EX: (ÃäÊã ÊõæóÕøõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 30 && formulaNo == 2);
    }
}
