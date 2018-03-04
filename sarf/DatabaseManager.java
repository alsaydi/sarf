package sarf;

import java.io.*;
import java.util.*;

import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.augmented.*;
import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.assimilate.*;
import sarf.noun.trilateral.unaugmented.elative.*;
import sarf.noun.trilateral.unaugmented.instrumental.*;
import sarf.noun.trilateral.unaugmented.timeandplace.*;
import sarf.noun.trilateral.unaugmented.exaggeration.XmExaggerationNounFormulaTree;
import sarf.noun.trilateral.unaugmented.exaggeration.XmExaggerationNounFormulaTreeCreator;
import sarf.gerund.trilateral.unaugmented.meem.*;

/**
 * <p>Title: </p>
 *
 * <p>Description:«·Õ’Ê· ⁄·Ï «·„⁄«—› «··€ÊÌ… „‰ ﬁÊ«⁄œ «·„⁄ÿÌ«               </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALECO</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class DatabaseManager {

    private DatabaseManager() {
    }

    private Map tripleUnaugmentedTreeMap = new HashMap();
    private Map quadriliteralUnaugmentedTreeMap = new HashMap();
    private Map quadriliteralAugmentedTreeMap = new HashMap();
    private Map tripleAugmentedTreeMap = new HashMap();
    private Map assimilateAdjectiveMap = new HashMap();
    private Map elativeNounMap = new HashMap();
    private Map instrumentalNounMap = new HashMap();
    private Map timeAndPlaceNounMap = new HashMap();
    private Map exaggerationNounMap = new HashMap();

    private Map meemGerundMap = new HashMap();


    private Map allNounsTreeMap = new HashMap();

    private static DatabaseManager instance = new DatabaseManager();

    public static DatabaseManager getInstance() {
        return instance;
    }

    /**
     * «·Õ’Ê· ⁄·Ï ﬁ«∆„… «·Ã–Ê— «·À·«ÀÌ… «·„Ã—œ… Õ”» Õ—›Â« «·√Ê·
     * @param c1 char
     * @return UnaugmentedTrilateralRootTree
     */
    public UnaugmentedTrilateralRootTree getUnaugmentedTrilateralRootTree(char c1) {
        UnaugmentedTrilateralRootTree rootsTree = (UnaugmentedTrilateralRootTree) tripleUnaugmentedTreeMap.get(c1+"");
        if (rootsTree == null) {
            try {
                rootsTree = UnaugmentedTrilateralRootTreeCreator.buildXmlVerbTree(new File("./db/trilateral/unaugmented/" + c1 + ".xml"));
                tripleUnaugmentedTreeMap.put(c1+"", rootsTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rootsTree;
    }

    /**
     * «·Õ’Ê· ⁄·Ï ﬁ«∆„… «·Ã–Ê— «·À·«ÀÌ… «·„“Ìœ… Õ”» Õ—›Â« «·√Ê·
     * @param c1 char
     * @return AugmentedTrilateralRootTree
     */
    public AugmentedTrilateralRootTree getAugmentedTrilateralRootTree(char c1) {
        AugmentedTrilateralRootTree rootsTree = (AugmentedTrilateralRootTree) tripleAugmentedTreeMap.get(c1+"");
        if (rootsTree == null) {
            try {
                rootsTree = AugmentedTrilateralRootTreeCreator.buildXmlVerbTree(new File("./db/trilateral/augmented/" + c1 + ".xml"));
                tripleAugmentedTreeMap.put(c1+"", rootsTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rootsTree;
    }

    /**
     * «·Õ’Ê· ⁄·Ï ﬁ«∆„… «·Ã–Ê— «·—»«⁄Ì… «·„Ã—œ… Õ”» Õ—›Â« «·√Ê·
     * @param c1 char
     * @return UnaugmentedQuadriliteralRootTree
     */
    public UnaugmentedQuadriliteralRootTree getUnaugmentedQuadriliteralRootTree(char c1) throws Exception{
        UnaugmentedQuadriliteralRootTree rootsTree = (UnaugmentedQuadriliteralRootTree) quadriliteralUnaugmentedTreeMap.get(c1+"");
        if (rootsTree == null) {

                rootsTree = UnaugmentedQuadriliteralRootTreeCreator.buildXmlVerbTree(new File("./db/quadriliteral/unaugmented/" + c1 + ".xml"));
                quadriliteralUnaugmentedTreeMap.put(c1+"", rootsTree);

        }
        return rootsTree;
    }

    /**
     * «·Õ’Ê· ⁄·Ï ﬁ«∆„… «·Ã–Ê— «·—»«⁄Ì… «·„“Ìœ… Õ”» Õ—›Â« «·√Ê·
     * @param c1 char
     * @return AugmentedQuadriliteralRootTree
     */
    public AugmentedQuadriliteralRootTree getAugmentedQuadriliteralRootTree(char c1) throws Exception{
        AugmentedQuadriliteralRootTree rootsTree = (AugmentedQuadriliteralRootTree) quadriliteralAugmentedTreeMap.get(c1+"");
        if (rootsTree == null) {

                rootsTree = AugmentedQuadriliteralRootTreeCreator.buildXmlVerbTree(new File("./db/quadriliteral/augmented/" + c1 + ".xml"));
                quadriliteralAugmentedTreeMap.put(c1+"", rootsTree);

        }
        return rootsTree;
    }

    /**
     * «·Õ’Ê· ⁄·Ï ﬁ«∆„… ﬁÊ«‰Ì‰ «·√”„«¡ Õ”» Õ—›Â« «·√Ê· ÊÕ”» ‰Ê⁄ «·«”„
     * @param c1 char
     * @return UnaugmentedTrilateralRootTree
     */
    public XmlNounFormulaTree getXmlNounFormulaTree(char c1, String folderName) {
        Map folderMap = (Map) allNounsTreeMap.get(folderName);
        if (folderMap == null) {
            allNounsTreeMap.put(folderName, folderMap = new HashMap());
        }

        XmlNounFormulaTree formulaTree = (XmlNounFormulaTree) folderMap.get(c1+"");
        if (formulaTree == null) {
            try {
                File file = new File("./db/noun/"+folderName+"/" + c1 + ".xml");
                if (!file.exists())
                    //there is no applied file for this char
                    return null;

                formulaTree = XmlNounFormulaTreeCreator.buildNounFormulaTree(file);
                folderMap.put(c1+"", formulaTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return formulaTree;
    }

    public XmlMeemGerundNounFormulaTree getMeemGerundFormulaTree(char c1) {

        XmlMeemGerundNounFormulaTree formulaTree = (XmlMeemGerundNounFormulaTree) meemGerundMap.get(c1+"");
        if (formulaTree == null) {
            try {
                File file = new File("./db/gerund/meem/" + c1 + ".xml");
                if (!file.exists())
                    //there is no applied file for this char
                    return null;

                formulaTree = XmlMeemGerundNounFormulaTreeCreator.buildNounFormulaTree(file);
                meemGerundMap.put(c1+"", formulaTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return formulaTree;
    }


    public AssimilateAdjectiveFormulaTree getAssimilateAdjectiveFormulaTree(char c1) {
        AssimilateAdjectiveFormulaTree formulaTree = (AssimilateAdjectiveFormulaTree) assimilateAdjectiveMap.get(c1+"");
        if (formulaTree == null) {
            try {
                File file = new File("./db/noun/assimilate/" + c1 + ".xml");
                if (!file.exists())
                    //there is no applied file for this char
                    return null;
                formulaTree = AssimilateAdjectiveFormulaTreeCreator.buildNounFormulaTree(file);
                assimilateAdjectiveMap.put(c1+"", formulaTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return formulaTree;
    }

    public ElativeNounFormulaTree getElativeNounFormulaTree(char c1) {
        ElativeNounFormulaTree formulaTree = (ElativeNounFormulaTree) elativeNounMap.get(c1+"");
        if (formulaTree == null) {
            try {
                File file = new File("./db/noun/elative/" + c1 + ".xml");
                if (!file.exists())
                    //there is no applied file for this char
                    return null;
                formulaTree = ElativeNounFormulaTreeCreator.buildNounFormulaTree(file);
                elativeNounMap.put(c1+"", formulaTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return formulaTree;
    }


    public XmlNonStandardInstrumentalNounFormulaTree getInstrumentalNounFormulaTree(char c1) {
        XmlNonStandardInstrumentalNounFormulaTree formulaTree = (XmlNonStandardInstrumentalNounFormulaTree) instrumentalNounMap.get(c1+"");
        if (formulaTree == null) {
            try {
                File file = new File("./db/noun/instrumental/" + c1 + ".xml");
                if (!file.exists())
                    //there is no applied file for this char
                    return null;
                formulaTree = XmlNonStandardInstrumentalNounFormulaTreeCreator.buildNounFormulaTree(file);
                instrumentalNounMap.put(c1+"", formulaTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return formulaTree;
    }

    public XmExaggerationNounFormulaTree getExaggerationNounFormulaTree(char c1) {
        XmExaggerationNounFormulaTree formulaTree = (XmExaggerationNounFormulaTree) exaggerationNounMap.get(c1+"");
        if (formulaTree == null) {
            try {
                File file = new File("./db/noun/exaggeration/" + c1 + ".xml");
                if (!file.exists())
                    //there is no applied file for this char
                    return null;
                formulaTree = XmExaggerationNounFormulaTreeCreator.buildNounFormulaTree(file);
                exaggerationNounMap.put(c1+"", formulaTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return formulaTree;
    }



    public XmlTimeAndPlaceNounFormulaTree getTimeAndPlaceNounFormulaTree(char c1) {
        XmlTimeAndPlaceNounFormulaTree formulaTree = (XmlTimeAndPlaceNounFormulaTree) timeAndPlaceNounMap.get(c1+"");
        if (formulaTree == null) {
            try {
                File file = new File("./db/noun/timeandplace/" + c1 + ".xml");
                if (!file.exists())
                    //there is no applied file for this char
                    return null;
                formulaTree = XmlTimeAndPlaceNounFormulaTreeCreator.buildNounFormulaTree(file);
                timeAndPlaceNounMap.put(c1+"", formulaTree);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return formulaTree;
    }




}
