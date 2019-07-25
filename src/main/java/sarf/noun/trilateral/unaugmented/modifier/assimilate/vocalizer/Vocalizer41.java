package sarf.noun.trilateral.unaugmented.modifier.assimilate.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

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
public class Vocalizer41 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Vocalizer41() {
        substitutions.add(new SuffixSubstitution("ِوُ", "ِي")); // EX: (هذا الرَّضِي )
        substitutions.add(new SuffixSubstitution("ِوَ", "ِيَ")); // EX: (رأيتُ الرَّضِيَ )
        substitutions.add(new SuffixSubstitution("ِوِ", "ِي")); // EX: (مررت على الرَّضِي )
        substitutions.add(new InfixSubstitution("ِوٌ", "ٍ")); // EX: (هذا رَضٍ، )
        substitutions.add(new InfixSubstitution("ِوٍ", "ٍ")); // EX: (مررت على رَضٍ، )
        substitutions.add(new InfixSubstitution("ِوً", "ِيً")); // EX: (رأيت رَضِيًا، )
        substitutions.add(new InfixSubstitution("ِوَ", "ِيَ")); // EX: (رَضِيان، رَضِيَةٌ، )
        substitutions.add(new InfixSubstitution("ِوُو", "ُو")); // EX: (رَضُونَ، )
        substitutions.add(new InfixSubstitution("ِوِي", "ِي")); // EX: (رَضِينَ )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return nounFormula.equals("فَعِل") && kov == KindOfVerb.Naqis_Wawi && noc == Conjugation.Forth;
    }
}
