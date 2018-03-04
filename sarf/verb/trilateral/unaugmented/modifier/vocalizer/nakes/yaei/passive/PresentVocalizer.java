package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.passive;

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
public class PresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (íõÑúãóì¡ íÓÚì¡ íÎÔì )
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (áä íõÑúãóì¡ íÓÚì¡ íÎÔì )
        substitutions.add(new SuffixSubstitution("óíú","ó"));// EX: (áã íõÑãó¡ íÓÚó¡ íÎÔó)
        substitutions.add(new InfixSubstitution("óíöí","óíú"));// EX: (ÃäÊö ÊõÑãóíúäó¡ ÊÓÚóíúäó¡ ÊÎÔíä )
        substitutions.add(new InfixSubstitution("óíõæ","óæú"));// EX: (ÃäÊã ÊõÑãóæúäó¡ ÊÓÚóæúäó¡ ÊÎÔæä )
        substitutions.add(new InfixSubstitution("óíõä","óæõä"));// EX: (ÃäÊã ÊõÑãóæõäøó¡ ÊõÓÚóæõäøó¡ ÊõÎÔæõäøó )
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
