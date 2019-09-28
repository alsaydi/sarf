package sarf.gerund.modifier.trilateral.unaugmented.quality;

import sarf.gerund.modifier.trilateral.unaugmented.quality.hamza.EinMahmouz;
import sarf.gerund.modifier.trilateral.unaugmented.quality.hamza.FaaMahmouz;
import sarf.gerund.modifier.trilateral.unaugmented.quality.hamza.LamMahmouz;
import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.substitution.SubstitutionsApplier;

import java.util.ArrayList;
import java.util.List;

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
        for (var mahmouz : modifiers) {
            var modifier = (IUnaugmentedTrilateralNounModificationApplier) mahmouz;
            if (modifier.isApplied(conjResult)) {
                mahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }

        //الأفعال الثلاثية المجردة المهموزة الفاء والمهموزة اللام (وهي: أبأ، أثأ، أجأ، أزأ، أكأ)
        if (conjResult.getRoot().getC3() == 'ء') {
            modifiers.get(2).apply(conjResult.getFinalResult(), conjResult.getRoot());
        }
    }
}
