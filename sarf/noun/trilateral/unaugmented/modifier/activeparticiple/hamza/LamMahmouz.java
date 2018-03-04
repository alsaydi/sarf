package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.hamza;

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
public class LamMahmouz extends AbstractLamMahmouz {
    List substitutions = new LinkedList();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ÙóÇãöÆ)
        substitutions.add(new InfixSubstitution("ÇÁõ", "ÇÄõ")); // EX: (ÈÇÄæä )
        substitutions.add(new InfixSubstitution("öÂ","öÆóÇ"));// EX: (ÂËöÆÇä)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
