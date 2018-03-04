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
public class EinMahmouz extends AbstractEinMahmouz {
    List substitutions = new LinkedList();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("óÁøóÇ","óÂøó"));// EX: (ÓÂøóá)
        substitutions.add(new InfixSubstitution("óÁõ","óÄõ"));// EX: (ÓóÄõæá)
        substitutions.add(new InfixSubstitution("õÁó","õÄó"));// EX: (ÓõÄóáóÉ)
        substitutions.add(new InfixSubstitution("óÁö","óÆö"));// EX: (ÓóÆöãñ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
