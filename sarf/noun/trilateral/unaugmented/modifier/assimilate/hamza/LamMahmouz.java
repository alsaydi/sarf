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
public class LamMahmouz extends AbstractLamMahmouz {
    List substitutions = new LinkedList();

    public LamMahmouz() {

        substitutions.add(new SuffixSubstitution("íÁõ","íÁõ"));// EX: (ÇáÌÑíÁõ¡ )
        substitutions.add(new SuffixSubstitution("íÁó","íÁó"));// EX: (ÇáÌÑíÁó¡ )
        substitutions.add(new SuffixSubstitution("íÁö","íÁö"));// EX: (ÇáÌÑíÁö¡ )
        substitutions.add(new InfixSubstitution("íÁñ","íÁñ"));// EX: (ÌÑíÁñ¡ )
        substitutions.add(new InfixSubstitution("íÁò","íÁò"));// EX: (ÌÑíÁò¡ )
        substitutions.add(new InfixSubstitution("íÁ","íÆ"));// EX: (ÌóÑíÆÇğ¡ ÌóÑöíÆóÉğ¡ ÌóÑöíÆÇä)
        substitutions.add(new InfixSubstitution("öÁ","öÆ"));// EX: (ÙóãöÆñ¡ )
        substitutions.add(new InfixSubstitution("úÁóÇ","úÂ"));// EX: (ÙóãúÂä¡ )

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
