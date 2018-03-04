package sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza;

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
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ãöÆúÒóÑ¡ ãöÆÒÑÉ¡ ãöÆÒÇÑ)
        substitutions.add(new PrefixSubstitution("Áó", "Ãó")); // EX: (ÃÒøóÇÑÉ¡ )
        substitutions.add(new InfixSubstitution("ÇáÁó","ÇáÃó"));// EX: (ÃÊøóÇÁóÉ¡ ÃËøÇÁÉ)
        substitutions.add(new InfixSubstitution("Áö", "Åö")); // EX: (ÅÒÇÑ¡ )
        substitutions.add(new InfixSubstitution("Áõ", "Ãõ")); // EX: (ÃõÎúĞóÉ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
