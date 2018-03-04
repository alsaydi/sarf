package sarf.noun.trilateral.unaugmented.modifier.assimilate.hamza;

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
        substitutions.add(new InfixSubstitution("ÃóÁ","Â"));// EX: (ÂÏóã¡ ÂæóÏ)
        substitutions.add(new InfixSubstitution("Áó","Ã"));// EX: (ÃÈöÏñ¡ ÃÓúİÇä¡ Ããöíä¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
