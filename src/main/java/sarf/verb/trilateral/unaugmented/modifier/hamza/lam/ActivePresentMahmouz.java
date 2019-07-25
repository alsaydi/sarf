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
public class ActivePresentMahmouz extends AbstractLamMahmouz {
    private final List<Substitution> substitutions = new ArrayList<Substitution>();

    public ActivePresentMahmouz() {
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ")); // EX: (هو يبدأ)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ")); // EX: (هنَّ يبدأْنَ، لم يَبْدَأْ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (هما يبدأان، لن يبدأ)
        substitutions.add(new InfixSubstitution("َءُ", "َؤُ")); // EX: (هم يبدؤون)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ")); // EX: (أنتِ تبدئين، تَجْرُئين، تَبُوئين، تدائين، تَقِيئِينَ)
        substitutions.add(new InfixSubstitution("ُءُ", "ُؤُ")); // EX: (يَجْرُؤُ)
        substitutions.add(new InfixSubstitution("ُءَ", "ُؤَ")); // EX: (لن يَجْرُؤَ)
        substitutions.add(new InfixSubstitution("ُءْ", "ُؤْ")); // EX: (لم يجرُؤْ، لم يَبُؤْ، هنَّ يَبُؤْنَ)
        substitutions.add(new InfixSubstitution("ِءْ", "ِئْ")); // EX: (لم يَقِئْ، هنّ يَقِئْنَ)
        substitutions.add(new InfixSubstitution("اءُو", "اؤُو")); // EX: (هم يَداؤون)
        substitutions.add(new InfixSubstitution("اءُن", "اؤُن")); // EX: (هم يشاؤُنَّ،)
        substitutions.add(new InfixSubstitution("يءَا", "يئَا")); // EX: (هما يَقِيئَان)
        substitutions.add(new InfixSubstitution("يءَن", "يئَن")); // EX: (هو يَقِيئَنَّ)
        substitutions.add(new InfixSubstitution("يءُو", "يئُو")); // EX: (هم يَقِيئُونَ)
        substitutions.add(new InfixSubstitution("يءُن", "يئُن")); // EX: (هم يجيئنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
