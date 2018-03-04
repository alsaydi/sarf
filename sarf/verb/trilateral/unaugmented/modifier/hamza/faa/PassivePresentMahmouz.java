package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;
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
public class PassivePresentMahmouz extends AbstractFaaMahmouz {
    private List substitutions = new ArrayList();

    public PassivePresentMahmouz() {
        substitutions.add(new InfixSubstitution("أُءْ", "أُو")); // EX: (أُوكَل)
        substitutions.add(new InfixSubstitution("ُءْ","ُؤْ"));// EX: (يُؤْكَل)
        substitutions.add(new InfixSubstitution("ُءَ", "ُؤَ")); // EX: (يُؤَاب، يُؤَان)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
