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
public class EinMahmouz extends AbstractEinMahmouz {
    List<Substitution> substitutions = new ArrayList<>();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("وْءَ", "وْءَ")); // EX: (مُسْتَوْءَل)
        substitutions.add(new InfixSubstitution("يْءَ", "يْئَ")); // EX: (مُسْتَيْئَس)
        substitutions.add(new InfixSubstitution("ْءً", "ْأً")); // EX: (مُنْأًى، مُمْأًى)
        substitutions.add(new InfixSubstitution("َءً", "َأً")); // EX: (مُنْفَأًى)
        substitutions.add(new InfixSubstitution("ْءَا", "ْآ")); // EX: (مُنْآة، مُمْآة)
        substitutions.add(new InfixSubstitution("َءَا", "َآ")); // EX: (مُنْفَآة)
        substitutions.add(new InfixSubstitution("ْءَ", "ْأَ")); // EX: (مُشْأَمٌ، مُبْتَأَسٌ، مُسْتَرْأَفٌ، مُجْأَلٌّ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ")); // EX: (مُنْذَأج)
        substitutions.add(new InfixSubstitution("َءَّا", "َآَّ")); // EX: (مُرَآَّة)
        substitutions.add(new InfixSubstitution("َءَّ", "َأَّ")); // EX: (مُرَأَّسٌ، مُتَرَأَّفٌ)
        substitutions.add(new InfixSubstitution("َءًّ", "َأًّ")); // EX: (مُرَأًّى)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
