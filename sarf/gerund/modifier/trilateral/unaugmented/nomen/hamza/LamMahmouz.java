package sarf.gerund.modifier.trilateral.unaugmented.nomen.hamza;

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
        substitutions.add(new InfixSubstitution("óÁóÇ","óÂ"));// EX: (æØÂÊ)
        substitutions.add(new InfixSubstitution("óÃóÇ","óÂ"));// EX: (ÃËÂÊ)
        substitutions.add(new InfixSubstitution("æúÁó","æúÁó"));// EX: (ÈóæúÁóÉ)
        substitutions.add(new InfixSubstitution("íúÁó","íúÆó"));// EX: (åóíúÆóÉ)
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ÈÏÃÉ¡ æØÃÉ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
