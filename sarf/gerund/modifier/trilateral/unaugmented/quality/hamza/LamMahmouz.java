package sarf.gerund.modifier.trilateral.unaugmented.quality.hamza;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
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
public class LamMahmouz extends AbstractLamMahmouz {
    List substitutions = new LinkedList();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("íÁó", "íÆó")); // EX: (åöíÆóÉ¡ ÈöíÆóÉ)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ÈöÏÃÉ¡ æöØÃÉ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
