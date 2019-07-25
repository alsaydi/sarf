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
public class EinMahmouz extends AbstractEinMahmouz {
    List<Substitution> substitutions = new ArrayList<>();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (نأْمَة، وَأْدَة)
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: (نأَمات)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
