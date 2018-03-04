package sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class FaaMahmouz extends AbstractFaaMahmouz {
    List substitutions = new LinkedList();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (ãÂäöíİ¡)
        substitutions.add(new PrefixSubstitution("ÇáÁó","ÇáÃó"));// EX: (ÇáÃóßøóÇá¡ ÇáÃßæá¡)
        substitutions.add(new PrefixSubstitution("ÇáÁõ","ÇáÃõ"));// EX: (ÇáÃõßóáóÉ¡)
        substitutions.add(new PrefixSubstitution("Áó", "Ãó")); // EX: (ÃóßøóÇá¡ Ãßæá¡)
        substitutions.add(new PrefixSubstitution("Áõ", "Ãõ")); // EX: (ÃõßóáóÉ¡)
        substitutions.add(new InfixSubstitution("öÁú", "öÆú")); // EX: (ãöÆúäÇİ¡)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
