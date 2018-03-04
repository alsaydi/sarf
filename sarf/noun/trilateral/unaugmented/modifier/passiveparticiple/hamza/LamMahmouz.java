package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
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

        substitutions.add(new SuffixSubstitution("õæÁö","õæÁö"));// EX: (ÇáãóÈúÏõæÁö )
        substitutions.add(new InfixSubstitution("õæÁö","õæÆö"));// EX: (ãóÈúÏõæÆöíäó )
        substitutions.add(new SuffixSubstitution("öíÁó","öíÁó"));// EX: (ÇáãóŞöíÁó )
        substitutions.add(new SuffixSubstitution("öíÁõ","öíÁõ"));// EX: (ÇáãóŞöíÁõ )
        substitutions.add(new SuffixSubstitution("öíÁö","öíÁö"));// EX: (ÇáãóŞöíÁö )
        substitutions.add(new InfixSubstitution("öíÁñ","öíÁñ"));// EX: (ãóŞöíÁñ )
        substitutions.add(new InfixSubstitution("öíÁò","öíÁò"));// EX: (ãóŞöíÁò )
        substitutions.add(new InfixSubstitution("öíÁ","öíÆ"));// EX: (ãóŞöíÆóÉñ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

}
