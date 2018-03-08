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
 * <p>
 * Title:
 * </p>
 *
 * <p>
 * Description:الحصول على المعارف اللغوية من قواعد المعطيات
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 *
 * <p>
 * Company: ALECO
 * </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class DatabaseManager {

	private DatabaseManager() {
	}

	private Map<String, UnaugmentedTrilateralRootTree> tripleUnaugmentedTreeMap = new HashMap<>();
	private Map<String, AugmentedTrilateralRootTree> tripleAugmentedTreeMap = new HashMap<>();

	private Map<String, UnaugmentedQuadriliteralRootTree> quadriliteralUnaugmentedTreeMap = new HashMap<>();
	private Map<String, AugmentedQuadriliteralRootTree> quadriliteralAugmentedTreeMap = new HashMap<>();

	private Map<String, AssimilateAdjectiveFormulaTree> assimilateAdjectiveMap = new HashMap<>();
	private Map<String, ElativeNounFormulaTree> elativeNounMap = new HashMap<>();
	private Map<String, XmlNonStandardInstrumentalNounFormulaTree> instrumentalNounMap = new HashMap<>();
	private Map<String, XmlTimeAndPlaceNounFormulaTree> timeAndPlaceNounMap = new HashMap<>();
	private Map<String, XmExaggerationNounFormulaTree> exaggerationNounMap = new HashMap<>();
	private Map<String, XmlMeemGerundNounFormulaTree> meemGerundMap = new HashMap<>();
	private Map<String, Map<String, XmlNounFormulaTree>> allNounsTreeMap = new HashMap<>();

	private static DatabaseManager instance = new DatabaseManager();

	public static DatabaseManager getInstance() {
		return instance;
	}

	/**
	 * الحصول على قائمة الجذور الثلاثية المجردة حسب حرفها الأول
	 * 
	 * @param c1
	 *            char
	 * @return UnaugmentedTrilateralRootTree
	 * @throws Exception
	 */
	public UnaugmentedTrilateralRootTree getUnaugmentedTrilateralRootTree(char c1) throws Exception {
		UnaugmentedTrilateralRootTree rootsTree = tripleUnaugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		rootsTree = UnaugmentedTrilateralRootTreeCreator
				.buildXmlVerbTree(new File("./db/trilateral/unaugmented/" + c1 + ".xml"));
		tripleUnaugmentedTreeMap.put(c1 + "", rootsTree);
		return rootsTree;
	}

	/**
	 * الحصول على قائمة الجذور الثلاثية المزيدة حسب حرفها الأول
	 * 
	 * @param c1
	 *            char
	 * @return AugmentedTrilateralRootTree
	 * @throws Exception
	 */
	public AugmentedTrilateralRootTree getAugmentedTrilateralRootTree(char c1) throws Exception {
		AugmentedTrilateralRootTree rootsTree = tripleAugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		rootsTree = AugmentedTrilateralRootTreeCreator
				.buildXmlVerbTree(new File("./db/trilateral/augmented/" + c1 + ".xml"));
		tripleAugmentedTreeMap.put(c1 + "", rootsTree);
		return rootsTree;
	}

	/**
	 * الحصول على قائمة الجذور الرباعية المجردة حسب حرفها الأول
	 * 
	 * @param c1
	 *            char
	 * @return UnaugmentedQuadriliteralRootTree
	 */
	public UnaugmentedQuadriliteralRootTree getUnaugmentedQuadriliteralRootTree(char c1) throws Exception {
		UnaugmentedQuadriliteralRootTree rootsTree = quadriliteralUnaugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		rootsTree = UnaugmentedQuadriliteralRootTreeCreator
				.buildXmlVerbTree(new File("./db/quadriliteral/unaugmented/" + c1 + ".xml"));
		quadriliteralUnaugmentedTreeMap.put(c1 + "", rootsTree);
		return rootsTree;
	}

	/**
	 * الحصول على قائمة الجذور الرباعية المزيدة حسب حرفها الأول
	 * 
	 * @param c1
	 *            char
	 * @return AugmentedQuadriliteralRootTree
	 */
	public AugmentedQuadriliteralRootTree getAugmentedQuadriliteralRootTree(char c1) throws Exception {
		AugmentedQuadriliteralRootTree rootsTree = quadriliteralAugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		rootsTree = AugmentedQuadriliteralRootTreeCreator
				.buildXmlVerbTree(new File("./db/quadriliteral/augmented/" + c1 + ".xml"));
		quadriliteralAugmentedTreeMap.put(c1 + "", rootsTree);
		return rootsTree;
	}

	/**
	 * الحصول على قائمة قوانين الأسماء حسب حرفها الأول وحسب نوع الاسم
	 * 
	 * @param c1
	 *            char
	 * @return UnaugmentedTrilateralRootTree
	 * @throws Exception
	 */
	public XmlNounFormulaTree getXmlNounFormulaTree(char c1, String folderName) throws Exception {
		Map<String, XmlNounFormulaTree> folderMap = allNounsTreeMap.get(folderName);
		if (folderMap == null) {
			allNounsTreeMap.put(folderName, folderMap = new HashMap<>());
		}

		XmlNounFormulaTree formulaTree = folderMap.get(c1 + "");
		if (formulaTree != null)
			return formulaTree;

		String fileName = "./db/noun/" + folderName + "/" + c1 + ".xml";
		File file = new File(fileName);
		if (!file.exists())
			// there is no applied file for this char
			throw new FileNotFoundException(fileName + " was not found.");

		formulaTree = XmlNounFormulaTreeCreator.buildNounFormulaTree(file);
		folderMap.put(c1 + "", formulaTree);
		return formulaTree;
	}

	public XmlMeemGerundNounFormulaTree getMeemGerundFormulaTree(char c1) throws Exception {
		XmlMeemGerundNounFormulaTree formulaTree = meemGerundMap.get(c1 + "");
		if (formulaTree != null)
			return formulaTree;

		File file = new File("./db/gerund/meem/" + c1 + ".xml");
		if (!file.exists())
			// there is no applied file for this char
			return null;

		formulaTree = XmlMeemGerundNounFormulaTreeCreator.buildNounFormulaTree(file);
		meemGerundMap.put(c1 + "", formulaTree);
		return formulaTree;
	}

	public AssimilateAdjectiveFormulaTree getAssimilateAdjectiveFormulaTree(char c1) {
		AssimilateAdjectiveFormulaTree formulaTree = assimilateAdjectiveMap.get(c1 + "");
		if (formulaTree == null) {
			try {
				File file = new File("./db/noun/assimilate/" + c1 + ".xml");
				if (!file.exists())
					// there is no applied file for this char
					return null;
				formulaTree = AssimilateAdjectiveFormulaTreeCreator.buildNounFormulaTree(file);
				assimilateAdjectiveMap.put(c1 + "", formulaTree);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return formulaTree;
	}

	public ElativeNounFormulaTree getElativeNounFormulaTree(char c1) {
		ElativeNounFormulaTree formulaTree = elativeNounMap.get(c1 + "");
		if (formulaTree == null) {
			try {
				File file = new File("./db/noun/elative/" + c1 + ".xml");
				if (!file.exists())
					// there is no applied file for this char
					return null;
				formulaTree = ElativeNounFormulaTreeCreator.buildNounFormulaTree(file);
				elativeNounMap.put(c1 + "", formulaTree);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return formulaTree;
	}

	public XmlNonStandardInstrumentalNounFormulaTree getInstrumentalNounFormulaTree(char c1) {
		XmlNonStandardInstrumentalNounFormulaTree formulaTree = instrumentalNounMap.get(c1 + "");
		if (formulaTree == null) {
			try {
				File file = new File("./db/noun/instrumental/" + c1 + ".xml");
				if (!file.exists())
					// there is no applied file for this char
					return null;
				formulaTree = XmlNonStandardInstrumentalNounFormulaTreeCreator.buildNounFormulaTree(file);
				instrumentalNounMap.put(c1 + "", formulaTree);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return formulaTree;
	}

	public XmExaggerationNounFormulaTree getExaggerationNounFormulaTree(char c1) {
		XmExaggerationNounFormulaTree formulaTree = exaggerationNounMap.get(c1 + "");
		if (formulaTree == null) {
			try {
				File file = new File("./db/noun/exaggeration/" + c1 + ".xml");
				if (!file.exists())
					// there is no applied file for this char
					return null;
				formulaTree = XmExaggerationNounFormulaTreeCreator.buildNounFormulaTree(file);
				exaggerationNounMap.put(c1 + "", formulaTree);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return formulaTree;
	}

	public XmlTimeAndPlaceNounFormulaTree getTimeAndPlaceNounFormulaTree(char c1) {
		XmlTimeAndPlaceNounFormulaTree formulaTree = timeAndPlaceNounMap.get(c1 + "");
		if (formulaTree == null) {
			try {
				File file = new File("./db/noun/timeandplace/" + c1 + ".xml");
				if (!file.exists())
					// there is no applied file for this char
					return null;
				formulaTree = XmlTimeAndPlaceNounFormulaTreeCreator.buildNounFormulaTree(file);
				timeAndPlaceNounMap.put(c1 + "", formulaTree);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return formulaTree;
	}
}
