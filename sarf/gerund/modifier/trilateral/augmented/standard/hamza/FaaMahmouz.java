package sarf.gerund.modifier.trilateral.augmented.standard.hamza;

import java.util.*;

import sarf.noun.trilateral.augmented.modifier.*;
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
public class FaaMahmouz extends AbstractFaaMahmouz {
    List substitutions = new LinkedList();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("ÅöÁú", "Åöí")); // EX: (ÅíËÇÑ)
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÊÃËíÑ)
        substitutions.add(new PrefixSubstitution("ÇáÇÁú","ÇáÇÆú"));// EX: (ÇáÇÆÊãÇÑ)
        substitutions.add(new PrefixSubstitution("ÇáÁö","ÇáÅö"));// EX: (ÇáÅÌÇÑ)
        substitutions.add(new PrefixSubstitution("ÇÁú", "ÇÆú")); // EX: (ÇÆÊãÇÑ)
        substitutions.add(new PrefixSubstitution("Áö", "Åö")); // EX: (ÅÌÇÑ)
        substitutions.add(new InfixSubstitution("õÁó", "õÄó")); // EX: (ãõÄóÇÌóÑÉ)
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ÇÓÊÆãÇÑ)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ÇäÆØÇÑ)
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (ÊÂßá)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÊÃßøöÏ)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
