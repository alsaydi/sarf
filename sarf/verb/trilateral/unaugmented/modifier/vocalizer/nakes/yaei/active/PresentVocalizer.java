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
public class PresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PresentVocalizer() {

        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (íÑãí)
        substitutions.add(new SuffixSubstitution("öíú","ö"));// EX: (áã íÑãö)
        substitutions.add(new InfixSubstitution("öíöä","öä"));// EX: (ÃäÊö ÊóÑúãöäøó)
        substitutions.add(new InfixSubstitution("öíö","ö"));// EX: (ÃäÊö ÊÑãíä)
        substitutions.add(new InfixSubstitution("öíú","öí"));// EX: (ÇäÊä ÊÑãíä)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ÃäÊã ÊÑãæä¡ ÊóÑúãõäøó)
        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (íÓÚì¡ íÎÔì )
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (áä íÓÚì¡ íÎÔì )
        substitutions.add(new SuffixSubstitution("óíú","ó"));// EX: (áã íÓÚó¡ íÎÔó)
        substitutions.add(new InfixSubstitution("óíöí","óíú"));// EX: (ÃäÊö ÊÓÚóíúäó¡ ÊÎÔíä )
        substitutions.add(new InfixSubstitution("óíõæ","óæú"));// EX: (ÃäÊã ÊÓÚóæúäó¡ ÊÎÔæä )
        substitutions.add(new InfixSubstitution("óíõä","óæõä"));// EX: (ÃäÊã ÊÓÚóæõäøó¡ ÊóÎúÔóæõäøó )

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
