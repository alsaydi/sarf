package sarf.verb.trilateral.augmented.modifier.hamza.faa.active;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.verb.trilateral.augmented.modifier.hamza.faa.*;

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
public class PresentMahmouz extends AbstractFaaMahmouz {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentMahmouz() {

        substitutions.add(new InfixSubstitution("أُءْ", "أُو")); // EX: (أنا أُوثِرُ، )
        substitutions.add(new InfixSubstitution("أَءْ", "آ")); // EX: (أنا آتَمِرُ، )
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (يَتَآكَلُ)
        substitutions.add(new InfixSubstitution("ْءَا", "ْآ")); // EX: (يَنْآدُ)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (يَأْتَمِرُ، يسْتَأْمِرُ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (يَتَأَكَّدُ، )
        substitutions.add(new InfixSubstitution("َءِ", "َئِ")); // EX: (يَسْتَئِمُّ، )
        substitutions.add(new InfixSubstitution("ُءِ", "ُئِ")); // EX: (يُئِيسُ، )
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (يُؤْثِرُ، )
        substitutions.add(new InfixSubstitution("ُءَ", "ُؤَ")); // EX: (يُؤَثِّرُ، يُؤَاجَرُ، )
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (يَنْأطِرُ، )
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
