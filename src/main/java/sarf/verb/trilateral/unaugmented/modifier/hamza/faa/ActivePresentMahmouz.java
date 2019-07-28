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
public class ActivePresentMahmouz extends AbstractFaaMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePresentMahmouz() {
        substitutions.add(new InfixSubstitution("أَءْ", "آ")); // EX: (آكُل)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (يَأْكَلَ)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (يَؤُوب، يَؤُمُّ)
        substitutions.add(new InfixSubstitution("َءِ", "َئِ")); // EX: (يَئِين، يَئِنُّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
