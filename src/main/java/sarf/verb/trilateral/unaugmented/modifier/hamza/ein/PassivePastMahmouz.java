package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;


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
public class PassivePastMahmouz extends AbstractEinMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePastMahmouz() {
        substitutions.add(new InfixSubstitution("ُءِ","ُئِ"));// EX: (سُئِلْتُ)
        substitutions.add(new InfixSubstitution("ُءُ","ُؤُ"));// EX: (رُؤُوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
