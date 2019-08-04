package sarf.noun.trilateral.unaugmented.exaggeration;

import com.google.inject.Inject;
import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula1;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula2;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula3;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula4;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula5;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula6;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula7;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula8;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula9;
import sarf.noun.trilateral.unaugmented.exaggeration.nonstandard.NounFormula10;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import sarf.*;

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
public class NonStandardExaggerationConjugator implements IUnaugmentedTrilateralNounConjugator {
    private final Map<String, Class> formulaClassNamesMap = new HashMap<>();
    //map <symbol,formulaName>
    private final Map<String, String> formulaSymbolsNamesMap = new HashMap<>();
    private final DatabaseManager databaseManager;

    @Inject
    public NonStandardExaggerationConjugator(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        buildFormulaMap(new NounFormula1());
        buildFormulaMap(new NounFormula2());
        buildFormulaMap(new NounFormula3());
        buildFormulaMap(new NounFormula4());
        buildFormulaMap(new NounFormula5());
        buildFormulaMap(new NounFormula6());
        buildFormulaMap(new NounFormula7());
        buildFormulaMap(new NounFormula8());
        buildFormulaMap(new NounFormula9());
        buildFormulaMap(new NounFormula10());
    }

    private void buildFormulaMap(NonStandardExaggerationNounFormula instance) {
        formulaClassNamesMap.put(instance.getFormulaName(), instance.getClass());
        formulaSymbolsNamesMap.put(instance.getSymbol(), instance.getFormulaName());
    }

    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaName) {
        Object[] parameters = {root, suffixNo + ""};

        try {
            Class<NounFormula> formulaClass = formulaClassNamesMap.get(formulaName);
            var constructor = formulaClass.getConstructor(UnaugmentedTrilateralRoot.class, String.class);
            return constructor.newInstance(parameters);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        return IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> createNoun(root, i, formulaName))
                .collect(Collectors.toList());

    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        XmExaggerationNounFormulaTree formulaTree = databaseManager.getExaggerationNounFormulaTree(root.getC1());
        if (formulaTree == null)
            return null;

        List<String> result = new ArrayList<>();

        for (Object o : formulaTree.getFormulaList()) {
            XmExaggerationNounFormula formula = (XmExaggerationNounFormula) o;
            if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                if (formula.getForm1() != null && !formula.getForm1().equals(""))
                    //add the formula pattern instead of the symbol (form1)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm1()));

                //may the verb has two forms of instrumentals
                if (formula.getForm2() != null && !formula.getForm2().equals(""))
                    //add the formula pattern instead of the symbol (form2)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm2()));

                //may the verb has two forms of instrumentals
                if (formula.getForm3() != null && !formula.getForm3().equals(""))
                    //add the formula pattern instead of the symbol (form3)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm3()));

            }
        }
        return result;
    }
}
