package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.hamza;

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
        substitutions.add(new InfixSubstitution("اءِ", "ائِ")); // EX: (سائِل)
        substitutions.add(new InfixSubstitution("اءُ", "اؤُ")); // EX: (ناؤُونَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
