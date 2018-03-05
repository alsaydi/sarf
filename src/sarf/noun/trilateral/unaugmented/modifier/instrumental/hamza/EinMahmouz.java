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

        substitutions.add(new InfixSubstitution("َءَّا","َآَّ"));// EX: (سآَّلَة)
        substitutions.add(new InfixSubstitution("ْءَا","ْآ"));// EX: (مِذآب)
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (مِذْأَب، مِذْأبَة)
        substitutions.add(new InfixSubstitution("ْءً","ْأً"));// EX: (مِمْأًى)
        substitutions.add(new InfixSubstitution("يءً","يئً"));// EX: (مِيئًى)
        substitutions.add(new InfixSubstitution("يءَ","يئَ"));// EX: (مِيئَد، مِيئَدة، مِيئاد)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
