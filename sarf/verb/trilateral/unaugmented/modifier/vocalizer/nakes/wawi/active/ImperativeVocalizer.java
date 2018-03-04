package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active;

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

        substitutions.add(new SuffixSubstitution("õæú", "õ")); // EX: (ÇÛúÒõ¡ ÇÓÑõ)
        substitutions.add(new InfixSubstitution("õæö", "ö")); // EX: (ÃäÊö ÇÛÒí¡ ÇÓÑí )
        substitutions.add(new InfixSubstitution("õæõæ", "õæ")); // EX: (ÃäÊã ÇÛÒæÇ¡ ÇÓÑæÇ )
        substitutions.add(new InfixSubstitution("õæúä", "õæä")); // EX: (ÃäÊä ÇÛÒæä¡ ÇÓÑæä)
        substitutions.add(new InfixSubstitution("õæõä", "õä")); // EX: (ÃäÊã ÇÛúÒõäøó )
        substitutions.add(new SuffixSubstitution("óæú", "ó")); // EX: (ÇÒúåó¡ ÇÑÖó)
        substitutions.add(new InfixSubstitution("óæöí", "óíú")); // EX: (ÃäÊö ÇÒåóíú¡ ÇÑÖóíú )
        substitutions.add(new InfixSubstitution("óæöä", "óíöä")); // EX: (ÃäÊö ÇÒåóíöäøó¡ ÇÑÖíöäøó)
        substitutions.add(new InfixSubstitution("óæúä", "óíúä")); // EX: (ÃäÊä ÇÒåóíúäó¡ ÇÒúåóíúäóÇäøö¡ ÇÑÖóíúäó)
        substitutions.add(new InfixSubstitution("óæõæ", "óæú")); // EX: (ÃäÊã ÇÒåóæúÇ¡ ÇÑÖóæúÇ)
        substitutions.add(new InfixSubstitution("óæóÇ", "óíóÇ")); // EX: (ÃäÊãÇ ÇÑÖíÇ¡ ÇÒúåóíóÇ¡ )
        substitutions.add(new InfixSubstitution("óæóä", "óíóä")); // EX: (ÃäÊó ÇÑÖíóäøó¡ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 21 || kov == 22 || kov == 23) && (noc == 1)) ||
                ((kov == 21 || kov == 23) && (noc == 5)) ||
                ((kov == 22 || kov == 23) && (noc == 3)) ||
                (kov == 23 && noc == 4);
    }
}
