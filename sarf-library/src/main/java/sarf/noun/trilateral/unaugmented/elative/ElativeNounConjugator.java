package sarf.noun.trilateral.unaugmented.elative;

import com.google.inject.Inject;
import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import sarf.*;
import sarf.noun.trilateral.unaugmented.elative.nonstandard.*;

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
public class ElativeNounConjugator implements IUnaugmentedTrilateralNounConjugator {
    private final DatabaseManager databaseManager;

    @Inject
    public ElativeNounConjugator(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName)
    {
        return this.createNounList(root, formulaName, ElativeSuffixContainer.getInstance());
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName, ElativeSuffixContainer elativeSuffixContainer) {
        return IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> new GenericElativeNounFormula(root, i + "", elativeSuffixContainer))
                .collect(Collectors.toList());
    }

    private static final List<String> formulas = new ArrayList<>(1);

    static {
        formulas.add("أَفْعَل");
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        ElativeNounFormulaTree formulaTree = databaseManager.getElativeNounFormulaTree(root.getC1());
        if (formulaTree == null) {
            return null;
        }
        for (Object o : formulaTree.getFormulaList()) {
            ElativeNounFormula formula = (ElativeNounFormula) o;
            if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                return formulas;
            }
        }
        return Collections.emptyList();
    }
}
