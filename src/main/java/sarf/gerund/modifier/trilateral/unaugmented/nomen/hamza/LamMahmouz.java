package sarf.gerund.modifier.trilateral.unaugmented.nomen.hamza;

import java.util.*;

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
private final List<Substitution> substitutions = new ArrayList<>();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("َءَا","َآ"));// EX: (وطآت)
        substitutions.add(new InfixSubstitution("َأَا","َآ"));// EX: (أثآت)
        substitutions.add(new InfixSubstitution("وْءَ","وْءَ"));// EX: (بَوْءَة)
        substitutions.add(new InfixSubstitution("يْءَ","يْئَ"));// EX: (هَيْئَة)
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (بدأة، وطأة)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
