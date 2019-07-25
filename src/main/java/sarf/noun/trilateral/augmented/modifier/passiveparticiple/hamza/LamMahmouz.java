package sarf.noun.trilateral.augmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.*;

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
    List<Substitution> substitutions = new ArrayList<>();

    public LamMahmouz() {

        substitutions.add(new SuffixSubstitution("اءَ","اءَ"));// EX: (مستاءَ)
        substitutions.add(new SuffixSubstitution("اءُ","اءُ"));// EX: (مستاءُ)
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (مستاءِ)
        substitutions.add(new InfixSubstitution("َءٌ", "َأٌ")); // EX: (مُجْزَأٌ، مُستَهْزَأٌ)
        substitutions.add(new InfixSubstitution("َءًا", "َأً")); // EX: (مُجْزَأً، مُستَهْزَأً)
        substitutions.add(new InfixSubstitution("اءًا", "اءً")); // EX: (مُداءً)
        substitutions.add(new InfixSubstitution("َءٍ", "َأٍ")); // EX: (مُجْزَأٍ، مُستَهْزَأٍ)
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (مُجْزَآنِ، مُستَهْزَآنَ)
        substitutions.add(new InfixSubstitution("َءَي", "َأَي")); // EX: (مُجْزَأيْنِ، مُستَهْزَأَيْنَ)
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (المجزَأُ، المُستَهْزَأُ)
        substitutions.add(new SuffixSubstitution("َءَ", "َأَ")); // EX: (المجزَأَ، المُستَهْزَأَ)
        substitutions.add(new SuffixSubstitution("َءِ", "َأِ")); // EX: (المجزَأِ، المُستَهْزَأِ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (المجزأَة، المستهزأة)
        substitutions.add(new InfixSubstitution("ءُ", "ؤُ")); // EX: (مُجْزَؤُونَ، مُستَهْزَؤُونَ)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (مُجْزَئِينَ، مُستَهْزَئِينَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
