package sarf.gerund.modifier.trilateral.unaugmented.meem.hamza;

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
        substitutions.add(new InfixSubstitution("ÇÁğÇ","ÇÁğ"));// EX: (ãóåÇÁğ)
        substitutions.add(new InfixSubstitution("óÁğÇ","óÃğ"));// EX: (ãóÈúÏÃğ)
        substitutions.add(new InfixSubstitution("íÁğ","íÆğ"));// EX: (ãóÌöíÆğÇ)
        substitutions.add(new InfixSubstitution("óÁ","óÃ"));// EX: (ãóÈúÏóÃ)
        substitutions.add(new InfixSubstitution("öÁ","öÆ"));// EX: (ãóæúÌöÆ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
