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
public class LamMahmouz extends AbstractLamMahmouz {
    List substitutions = new LinkedList();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("ÇÁğÇ","ÇÁğ"));// EX: (ÈÏøÇÁğ¡  )
        substitutions.add(new SuffixSubstitution("ÇÁõ","ÇÁõ"));// EX: (ÇáÈÏøÇÁõ )
        substitutions.add(new SuffixSubstitution("ÇÁö","ÇÁö"));// EX: (ÇáÈÏøÇÁö )
        substitutions.add(new InfixSubstitution("ÇÁõ","ÇÄõ"));// EX: (ÈÏøÇÄæä )
        substitutions.add(new InfixSubstitution("ÇÁö","ÇÆö"));// EX: (ÈÏøÇÆöíä )
        substitutions.add(new InfixSubstitution("óÁóÉ","óÃóÉ"));// EX: (åõÒóÃóÉ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
