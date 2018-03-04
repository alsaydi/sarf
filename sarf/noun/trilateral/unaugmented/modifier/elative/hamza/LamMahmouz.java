package sarf.noun.trilateral.unaugmented.modifier.elative.hamza;

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
        substitutions.add(new SuffixSubstitution("óÁõ","óÃõ"));// EX: (åæ ÇáÃÌÑÃõ¡ )
        substitutions.add(new SuffixSubstitution("óÁö","óÃö"));// EX: (ßÇáÃÌÑÃö¡ )
        substitutions.add(new InfixSubstitution("æúÁó","æÁó"));// EX: (ÇáÓøõæÁóì¡ )
        substitutions.add(new InfixSubstitution("óÁóÇ","óÂ"));// EX: (ÇáÃÌÑÂä¡ )
        substitutions.add(new InfixSubstitution("óÁõæ","óÄõæ"));// EX: (ÇáÃÌÑÄæä¡ )
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ÑÃíÊõ ÇáÃÌÑÃó¡ )
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ÇáÌõÑúÃóì¡ )
        substitutions.add(new InfixSubstitution("óÁö","óÆö"));// EX: (ÇáÃÌÑÆöíäó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
