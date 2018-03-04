package sarf.verb.trilateral.augmented.modifier.geminator.generic;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;

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
public class PassivePastGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PassivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3ó", "öC3øó")); // EX: (ÃõÍöÈøó¡)
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3õ", "öC3øõ")); // EX: (ÃõÍöÈøõæÇ¡)
        substitutions.add(new ExpressionInfixSubstitution("õC3öC3ó", "õC3øó")); // EX: (ÇäúŞõÖøó)
        substitutions.add(new ExpressionInfixSubstitution("õC3öC3õ", "õC3øõ")); // EX: (ÇäúŞõÖøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("æC3öC3ó", "æC3øó")); // EX: (ÍõæÌøó¡ ÇÍúãõæÑøó)
        substitutions.add(new ExpressionInfixSubstitution("æC3öC3õ", "æC3øõ")); // EX: (ÍõæÌøõæÇ¡ ÇÍúãõæÑøõæÇ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
