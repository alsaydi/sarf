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
public class PastMahmouz extends AbstractFaaMahmouz {

    private final List<Substitution> substitutions = new ArrayList<>();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("أَءْ","آ"));// EX: (آثَرَ، آتَى، آخَى، آوَى، )
        substitutions.add(new InfixSubstitution("ءَا","آ"));// EX: (آضَّ، تَآجَّ، آجَرَ، تآكَلَ، آوَبَ، انْآدَ، تآوَبَ، آيَسَ، آيَدَ، آسَى، تآخَى، آسى، تآثَى، تآوَى، )
        substitutions.add(new InfixSubstitution("ءَ","أَ"));// EX: (أمَّمَ، تأمَّمَ، اسْتأمَّ، أثَّر، انأطَرَ، تأكَّدَ، أوَّب، تأوَّبَ، أيَّدَ، تأيَّدَ، أبَّى، تأسَّى، أدَّى، تأتَّى، أوَّى، تأوَّى، )
        substitutions.add(new InfixSubstitution("اءْ","ائْ"));// EX: (ائْتَمَّ، ائْتَثَأَ، ائْتَمَرَ، ائْتَالَ، ائْتامَ، ائْتَسَى، ائْتَرَى، ائْتَوَى، )
        substitutions.add(new InfixSubstitution("َءْ","َأْ"));// EX: (اسْتَأْمَرَ، اسْتَأْوَرَ، استأيَكَ، اسْتَأمَى، استأنَى، اسْتَأْوَى، )
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
