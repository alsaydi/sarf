package sarf.verb.trilateral.augmented.modifier.hamza.faa.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
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
public class PastMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new ExpressionInfixSubstitution("أُءْيِC3ْ","أُئِC3ْ"));// EX: (أُئِستُ )
        substitutions.add(new InfixSubstitution("أُءْيِ","أُئِي"));// EX: (أُئِيس )
        substitutions.add(new InfixSubstitution("أُءْ", "أُو")); // EX: (أُوثِرَ، )
        substitutions.add(new InfixSubstitution("اءْتِ","ائْتِ"));// EX: (ائْتِلْتُ، )
        substitutions.add(new InfixSubstitution("ءِ","ئِ"));// EX: (انْئِيدََ، استُئمّ )
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ")); // EX: (انْؤُطِرَ، )
        substitutions.add(new PrefixSubstitution("ءُ", "أُ")); // EX: (أُثِّرَ، أُوجِرَ، )
        substitutions.add(new InfixSubstitution("اءْ", "اؤْ")); // EX: (اؤْتُمِرَ، )

        substitutions.add(new InfixSubstitution("ُءُ", "ُؤُ")); // EX: (تُؤُوكِلَ، تُؤُكِّدَ، )
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (استُؤْكِلَ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
