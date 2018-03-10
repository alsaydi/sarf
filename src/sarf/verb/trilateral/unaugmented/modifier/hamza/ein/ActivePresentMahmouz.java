package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

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
public class ActivePresentMahmouz extends AbstractEinMahmouz {
    private List<Substitution> substitutions = new ArrayList<Substitution>();

    public ActivePresentMahmouz() {
        substitutions.add(new SuffixSubstitution("ْءُ", "ْؤُ")); // EX: (لم يَمْؤُ)
        substitutions.add(new InfixSubstitution("يْءَ","يْئَ"));// EX: (يَيْئَس)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يَسْأَل)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (يَنْئِمُ، يَئِدُ)
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (يَضْؤُل)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (أنتم تَؤُوا، هم يَؤُوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
