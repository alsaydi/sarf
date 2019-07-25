package sarf.verb.trilateral.unaugmented.modifier.hamza.lam;

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
public class PassivePresentMahmouz extends AbstractLamMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePresentMahmouz() {
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (هو يُوطَأُ)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (هنَّ يُبدأْنَ، لم يُبْدَأْ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (هما يُبدأان، لن يُبدأ)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (هم يُبدؤون)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (أنتِ تُبدئين، تُبائين، تُدائين، تشائين)
        substitutions.add(new InfixSubstitution("اءُو", "اؤُو")); // EX: (هم يُباؤُون،  يُداؤون، يُشاؤون)
        substitutions.add(new InfixSubstitution("اءُن", "اؤُن")); // EX: (هم يساؤُنَّ، يجاؤنَّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
