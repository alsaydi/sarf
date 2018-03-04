package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

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
public class Ajwaf2Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Ajwaf2Vocalizer() {

        substitutions.add(new InfixSubstitution("اوِءٌ","اءٍ"));// EX: (هذا ناءٍ)
        substitutions.add(new InfixSubstitution("اوِءً","ائِيً"));// EX: (رأيتُ نائِياً)
        substitutions.add(new InfixSubstitution("اوِءٍ","اءٍ"));// EX: (مررتُ على ناءٍ)
        substitutions.add(new SuffixSubstitution("اوِءُ","ائِي"));// EX: (هذا النائِي، نائِي الـ، )
        substitutions.add(new SuffixSubstitution("اوِءَ","ائِيَ"));// EX: (رأيتُ النائيَ، نائِي الـ، )
        substitutions.add(new SuffixSubstitution("اوِءِ","ائِي"));// EX: (مررتُ على النائِي، نائِي الـ)
        substitutions.add(new InfixSubstitution("اوِءَ","ائِيَ"));// EX: (نائِيَةٌ، نائِيانِ،  )
        substitutions.add(new InfixSubstitution("اوِءُ","اؤُ"));// EX: (ناؤُونَ، )
        substitutions.add(new InfixSubstitution("اوِءِ","ائِ"));// EX: (نائِينَ، )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return kov == 16 && (noc ==1 || noc == 4);
    }
}
