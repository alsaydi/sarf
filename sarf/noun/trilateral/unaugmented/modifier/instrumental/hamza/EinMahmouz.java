package sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza;

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

        substitutions.add(new InfixSubstitution("óÁøóÇ","óÂøó"));// EX: (ÓÂøóáóÉ)
        substitutions.add(new InfixSubstitution("úÁóÇ","úÂ"));// EX: (ãöĞÂÈ)
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ãöĞúÃóÈ¡ ãöĞúÃÈóÉ)
        substitutions.add(new InfixSubstitution("úÁğ","úÃğ"));// EX: (ãöãúÃğì)
        substitutions.add(new InfixSubstitution("íÁğ","íÆğ"));// EX: (ãöíÆğì)
        substitutions.add(new InfixSubstitution("íÁó","íÆó"));// EX: (ãöíÆóÏ¡ ãöíÆóÏÉ¡ ãöíÆÇÏ)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
