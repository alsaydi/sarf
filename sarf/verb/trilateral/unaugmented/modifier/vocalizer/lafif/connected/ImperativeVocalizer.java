package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

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
        substitutions.add(new SuffixSubstitution("öíú", "ö")); // EX: (ÇÔúæö)
        substitutions.add(new InfixSubstitution("öíöä", "öä")); // EX: (ÃäÊö ÇÔúæöäøó)
        substitutions.add(new InfixSubstitution("öíö", "ö")); // EX: (ÃäÊö ÇÔúæöí)
        substitutions.add(new InfixSubstitution("öíú", "öí")); // EX: (ÃäÊä ÇÔúæöíäó)
        substitutions.add(new InfixSubstitution("öíõ", "õ")); // EX: (ÃäÊã ÇÔúæõæÇ)
        substitutions.add(new SuffixSubstitution("óíú", "ó")); // EX: (ÃäÊó ÇŞúæó¡ ÇÍúíó)
        substitutions.add(new InfixSubstitution("óíöí", "óíú")); // EX: (ÃäÊö ÇŞæóíú¡ ÇÍúíóíú)
        substitutions.add(new InfixSubstitution("óíõæ", "óæú")); // EX: (ÃäÊã ÇŞúæóæúÇ¡ ÇÍúíóæúÇ)
        substitutions.add(new InfixSubstitution("óíõä", "óæõä")); // EX: (ÃäÊã ÇŞúæóæõäøó¡ ÇÍíóæõäøó)
        substitutions.add(new SuffixSubstitution("óæú", "ó")); // EX: (ÇÓúæó)
        substitutions.add(new InfixSubstitution("óæöí", "óíú")); // EX: (ÃäÊö ÇÓúæóíú)
        substitutions.add(new InfixSubstitution("óæóä", "óíóä")); // EX: (ÃäÊó ÇÓúæóíóäøó)
        substitutions.add(new InfixSubstitution("óæúä", "óíúä")); // EX: (ÃäÊä ÇÓúæóíúäó)
        substitutions.add(new InfixSubstitution("óæöä", "óíöä")); // EX: (ÃäÊö ÇÓúæóíöäøó)
        substitutions.add(new InfixSubstitution("óæõæ", "óæú")); // EX: (ÃäÊã ÇÓúæóæúÇ)
        substitutions.add(new InfixSubstitution("óæó","óíó"));// EX: (ÃäÊãÇ ÇÓúæíÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 27 || kov == 28) && (noc == 2)) ||
                (kov == 28 && noc == 4);
    }
}
