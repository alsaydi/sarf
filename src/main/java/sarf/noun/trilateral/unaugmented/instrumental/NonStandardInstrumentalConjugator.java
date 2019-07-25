package sarf.noun.trilateral.unaugmented.instrumental;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
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
public class NonStandardInstrumentalConjugator implements IUnaugmentedTrilateralNounConjugator {
    private final Map<String, Class<?>> formulaClassNamesMap = new HashMap<>();
    //map <symbol,formulaName>
    private final Map<String, String> formulaSymbolsNamesMap = new HashMap<>();

    private NonStandardInstrumentalConjugator() {
        for (int i = 1; i <= 15; i++) {
            String formulaClassName = getClass().getPackage().getName() + ".nonstandard.NounFormula" + i;
            try {
                @SuppressWarnings("unchecked")
				Class<NonStandardInstrumentalNounFormula> formulaClass = (Class<NonStandardInstrumentalNounFormula>) Class.forName(formulaClassName);
                NonStandardInstrumentalNounFormula instrumentalNounFormula = (NonStandardInstrumentalNounFormula) formulaClass.getConstructor().newInstance();
                formulaClassNamesMap.put(instrumentalNounFormula.getFormulaName(), formulaClass);
                formulaSymbolsNamesMap.put(instrumentalNounFormula.getSymbol(), instrumentalNounFormula.getFormulaName());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static final NonStandardInstrumentalConjugator instance = new NonStandardInstrumentalConjugator();

    public static NonStandardInstrumentalConjugator getInstance() {
        return instance;
    }


    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaName) {
        Object[] parameters = {root, suffixNo + ""};

        try {
            Class<?> formulaClass = (Class<?>) formulaClassNamesMap.get(formulaName);
            return (NounFormula) formulaClass.getConstructor(root.getClass(), "".getClass()).newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List<NounFormula> result = new LinkedList<>();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = createNoun(root, i, formulaName);
            result.add(noun);
        }
        return result;
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        //فقط للفعل المتعدي
        if (!root.getTransitive().equals("م") && !root.getTransitive().equals("ك")) {
            return null;
        }

        XmlNonStandardInstrumentalNounFormulaTree formulaTree = DatabaseManager.getInstance().getInstrumentalNounFormulaTree(root.getC1());
        if (formulaTree == null) {
            return null;
        }

        List<String> result = new LinkedList<>();

        var iter = formulaTree.getFormulaList().iterator();
        while (iter.hasNext()) {
            var formula = (XmlNonStandardInstrumentalNounFormula) iter.next();
            if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                if (formula.getForm1() != null && formula.getForm1() != "") {
                    //add the formula pattern instead of the symbol (form1)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm1()));
                }

                //may the verb has two forms of instrumentals
                if (formula.getForm2() != null && formula.getForm2() != "") {
                    //add the formula pattern instead of the symbol (form2)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm2()));
                }
            }
        }
        return result;
    }
}
