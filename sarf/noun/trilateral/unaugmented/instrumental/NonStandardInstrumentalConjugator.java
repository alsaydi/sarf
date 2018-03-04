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
    private Map formulaClassNamesMap = new HashMap();
    //map <symbol,formulaName>
    private Map formulaSymbolsNamesMap = new HashMap();

    private NonStandardInstrumentalConjugator() {
        for (int i = 1; i <= 15; i++) {
            String formulaClassName = getClass().getPackage().getName() + ".nonstandard.NounFormula" + i;
            try {
                Class formulaClass = Class.forName(formulaClassName);
                NonStandardInstrumentalNounFormula instrumentalNounFormula = (NonStandardInstrumentalNounFormula) formulaClass.newInstance();
                formulaClassNamesMap.put(instrumentalNounFormula.getFormulaName(), formulaClass);
                formulaSymbolsNamesMap.put(instrumentalNounFormula.getSymbol(), instrumentalNounFormula.getFormulaName());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static NonStandardInstrumentalConjugator instance = new NonStandardInstrumentalConjugator();

    public static NonStandardInstrumentalConjugator getInstance() {
        return instance;
    }


    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaName) {
        Object[] parameters = {root, suffixNo + ""};

        try {
            Class formulaClass = (Class) formulaClassNamesMap.get(formulaName);
            NounFormula noun = (NounFormula) formulaClass.getConstructors()[1].newInstance(parameters);
            return noun;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = createNoun(root, i, formulaName);
            result.add(noun);
        }

        return result;
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        //ÝÞØ ááÝÚá ÇáãÊÚÏí
        if (!root.getTransitive().equals("ã") && !root.getTransitive().equals("ß")) {
            return null;
        }

        XmlNonStandardInstrumentalNounFormulaTree formulaTree = DatabaseManager.getInstance().getInstrumentalNounFormulaTree(root.getC1());
        if (formulaTree == null) {
            return null;
        }

        List result = new LinkedList();

        Iterator iter = formulaTree.getFormulaList().iterator();
        while (iter.hasNext()) {
            XmlNonStandardInstrumentalNounFormula formula = (XmlNonStandardInstrumentalNounFormula) iter.next();
            if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                if (formula.getForm1() != null && formula.getForm1() != "") {
                    //add the formula pattern insteaed of the symbol (form1)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm1()));
                }

                //may the verb has two forms of instumentals
                if (formula.getForm2() != null && formula.getForm2() != "") {
                    //add the formula pattern insteaed of the symbol (form2)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm2()));
                }
            }
        }

        return result;

    }


}
