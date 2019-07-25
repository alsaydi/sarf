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
public class FaaMahmouz extends AbstractFaaMahmouz {
    private final List<Substitution> substitutions = new LinkedList<>();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("إِءْ", "إِي")); // EX: (إيثار)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (تأثير)
        substitutions.add(new PrefixSubstitution("الاءْ","الائْ"));// EX: (الائتمار)
        substitutions.add(new PrefixSubstitution("الءِ","الإِ"));// EX: (الإجار)
        substitutions.add(new PrefixSubstitution("اءْ", "ائْ")); // EX: (ائتمار)
        substitutions.add(new PrefixSubstitution("ءِ", "إِ")); // EX: (إجار)
        substitutions.add(new InfixSubstitution("ُءَ", "ُؤَ")); // EX: (مُؤَاجَرة)
        substitutions.add(new InfixSubstitution("ِء", "ِئ")); // EX: (استئمار)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (انئطار)
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (تآكل)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (تأكِّد)

    }
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
