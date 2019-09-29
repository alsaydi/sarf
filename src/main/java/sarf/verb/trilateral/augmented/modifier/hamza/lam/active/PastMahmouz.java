package sarf.verb.trilateral.augmented.modifier.hamza.lam.active;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.verb.trilateral.augmented.modifier.hamza.lam.*;

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
public class PastMahmouz extends AbstractLamMahmouz {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (أجْزَأْتُ، كافأْتُ، انفقَأْتُ، ابتدَأْتُ، تدارَأْتُ، استَهْزَأْتُ، احْزَوْزَأْتُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (أجْزَأَ، كافَأَ، انْفَقَأَ، ابتدَأَ، تدارَأَ، استَهْزَأَ، احْزَوْزَأَ، )
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (أجْزَؤُوا، كافَؤُوا، انفقَؤُوا، ابتدَؤُوا، تدارَؤُوا، استَهْزَؤُوا، احْزَوْزَؤُوا)
        substitutions.add(new InfixSubstitution("َّءْ", "َّأْ")); // EX: (جَزَّأْتُ، تَخَبَّأْتُ، )
        substitutions.add(new InfixSubstitution("َّءَ", "َّأَ")); // EX: (جَزَّأَ، تَخَبَّأَ،)
        substitutions.add(new InfixSubstitution("َّءُ", "َّؤُ")); // EX: (جَزَّؤُوا، تَخَبَّؤُوا، )
        substitutions.add(new InfixSubstitution("اءَ", "اءَ")); // EX: (أساءَ، استاءَ، )
        substitutions.add(new InfixSubstitution("اءُ", "اؤُ")); // EX: (أساؤُوا، استاؤُوا، )
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
