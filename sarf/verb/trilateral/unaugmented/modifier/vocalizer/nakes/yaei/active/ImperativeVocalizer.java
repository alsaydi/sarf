package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
public class ImperativeVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ImperativeVocalizer() {
        substitutions.add(new SuffixSubstitution("öíú","ö"));// EX: (ÃäÊó ÇÑãö)
        substitutions.add(new InfixSubstitution("öíö","ö"));// EX: (ÃäÊö ÇÑãí)
        substitutions.add(new InfixSubstitution("öíú","öí"));// EX: (ÇäÊä ÇÑãíä)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ÃäÊã ÇÑãæÇ)
        substitutions.add(new SuffixSubstitution("óíú","ó"));// EX: (ÇÓÚó¡ ÇÎÔó)
        substitutions.add(new InfixSubstitution("óíöí","óíú"));// EX: (ÃäÊö ÇÓÚóíú¡ ÇÎÔí )
        substitutions.add(new InfixSubstitution("óíõæ","óæú"));// EX: (ÃäÊã ÇÓÚóæúÇ¡ ÇÎÔóæúÇ )
        substitutions.add(new InfixSubstitution("óíõä","óæõä"));// EX: (ÃäÊã ÇÓÚóæõäøó¡ ÇÎÔóæõäøó )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 24 || kov == 26) && (noc == 2)) ||
                ((kov == 24 || kov == 25 || kov == 26) && (noc == 3 || noc == 4));
    }
}
