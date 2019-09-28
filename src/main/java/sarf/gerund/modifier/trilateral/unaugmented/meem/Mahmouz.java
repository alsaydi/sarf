package sarf.gerund.modifier.trilateral.unaugmented.meem;

import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.gerund.modifier.trilateral.unaugmented.meem.hamza.*;
import sarf.ConjugationResult;

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
public class Mahmouz {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        for (Object o : modifiers) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) o;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }

        //الأفعال الثلاثية المجردة المهموزة الفاء والمهموزة اللام (وهي: أبأ، أثأ، أجأ، أزأ، أكأ)
        if (conjResult.getRoot().getC3() == 'ء')
            ((SubstitutionsApplier)modifiers.get(2)).apply(conjResult.getFinalResult(), conjResult.getRoot());

    }
}
