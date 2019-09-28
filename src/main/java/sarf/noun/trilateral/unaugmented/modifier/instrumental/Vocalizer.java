package sarf.noun.trilateral.unaugmented.modifier.instrumental;

import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer.*;
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
public class Vocalizer {
    private final List modifiers = new LinkedList();

    private final PreMithalLafifVocalizer preMithalLafifVocalizer = new PreMithalLafifVocalizer();

    public Vocalizer() {
        modifiers.add(new WawiNakesLafifVocalizer());
        modifiers.add(new YaeiNakesLafifVocalizer());
    }

    public void apply(NounConjugationResult conjResult) {
        // تطبيق اعلال واحد اولا
        if (preMithalLafifVocalizer.isApplied(conjResult))
            preMithalLafifVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());

        for (Object o : modifiers) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) o;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}

