package sarf.noun.trilateral.unaugmented.modifier.exaggeration;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza.EinMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza.FaaMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza.LamMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza.NakesLafifMahmouz;
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

    private final NakesLafifMahmouz nakesLafifMahmouz = new NakesLafifMahmouz();

    public Mahmouz() {
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
        //apply that after the 3 before
        if (nakesLafifMahmouz.isApplied(conjResult))
            nakesLafifMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());

        //الأفعال الثلاثية المجردة المهموزة الفاء والمهموزة اللام (وهي: أبأ، أثأ، أجأ، أزأ، أكأ)
        if (conjResult.getRoot().getC3() == 'ء')
            modifiers.get(2).apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
