package sarf.noun.trilateral.unaugmented.modifier.instrumental;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza.EinMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza.FaaMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza.LamMahmouz;
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
class Mahmouz {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    Mahmouz() {
        modifiers.add(new FaaMahmouz());
        modifiers.add(new EinMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }

        //الأفعال الثلاثية المجردة المهموزة الفاء والمهموزة اللام (وهي: أبأ، أثأ، أجأ، أزأ، أكأ)
        if (conjResult.getRoot().getC3() == 'ء')
            modifiers.get(2).apply(conjResult.getFinalResult(), conjResult.getRoot());

    }
}
