package sarf.gerund.modifier.trilateral.augmented.standard.hamza;

import java.util.*;

import sarf.noun.trilateral.augmented.modifier.*;
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
public class EinMahmouz extends AbstractEinMahmouz {
    private List<Substitution> substitutions = new LinkedList<>();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("َءُّ","َؤُّ"));// EX: (تَشَؤُّم)
        substitutions.add(new InfixSubstitution("يءَا","يئَا"));// EX: (إيئاب، استيئاس)
        substitutions.add(new InfixSubstitution("ءٍّ","أٍّ"));// EX: (تَفَأٍّ)
        substitutions.add(new InfixSubstitution("ءِّ","ئِّ"));// EX: (تَفَئِّيان)
        substitutions.add(new InfixSubstitution("ْءَا","ْآ"));// EX: (إشآم، استرآف)
        substitutions.add(new InfixSubstitution("ِء","ِئ"));// EX: (لِئام، انذئاج، ابتئاس، ارتئاء)
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (ترئيس، اجئلال)
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (تساؤل، ترؤّف)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
