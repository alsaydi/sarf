package sarf;

import java.io.*;
import java.util.*;

import sarf.util.FileUtil;
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

import static sarf.util.FileUtil.getResourceInputStream;

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

	private final Map<String, UnaugmentedTrilateralRootTree> tripleUnaugmentedTreeMap = new HashMap<>();
	private final Map<String, AugmentedTrilateralRootTree> tripleAugmentedTreeMap = new HashMap<>();

	private final Map<String, UnaugmentedQuadriliteralRootTree> quadrilateralUnaugmentedTreeMap = new HashMap<>();
	private final Map<String, AugmentedQuadriliteralRootTree> quadrilateralAugmentedTreeMap = new HashMap<>();

	private final Map<String, AssimilateAdjectiveFormulaTree> assimilateAdjectiveMap = new HashMap<>();
	private final Map<String, ElativeNounFormulaTree> elativeNounMap = new HashMap<>();
	private final Map<String, XmlNonStandardInstrumentalNounFormulaTree> instrumentalNounMap = new HashMap<>();
	private final Map<String, XmlTimeAndPlaceNounFormulaTree> timeAndPlaceNounMap = new HashMap<>();
	private final Map<String, XmExaggerationNounFormulaTree> exaggerationNounMap = new HashMap<>();
	private final Map<String, XmlMeemGerundNounFormulaTree> meemGerundMap = new HashMap<>();
	private final Map<String, Map<String, XmlNounFormulaTree>> allNounsTreeMap = new HashMap<>();

	private static final DatabaseManager instance = new DatabaseManager();

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
	UnaugmentedTrilateralRootTree getUnaugmentedTrilateralRootTree(char c1) throws Exception {
		UnaugmentedTrilateralRootTree rootsTree = tripleUnaugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;
		var resourceName = String.format("db/trilateral/unaugmented/%s.xml", c1);
		var inputStream = getResourceInputStream(resourceName);
		if(inputStream == null){
			throw new FileNotFoundException(resourceName);
		}
		rootsTree = UnaugmentedTrilateralRootTreeCreator.buildXmlVerbTree(inputStream);
		tripleUnaugmentedTreeMap.put(c1 + "", rootsTree);
		inputStream.close();
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
	AugmentedTrilateralRootTree getAugmentedTrilateralRootTree(char c1) throws Exception {
		AugmentedTrilateralRootTree rootsTree = tripleAugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		var inputStream = getResourceInputStream("db/trilateral/augmented/" + c1 + ".xml");
		rootsTree = AugmentedTrilateralRootTreeCreator.buildXmlVerbTree(inputStream);
		tripleAugmentedTreeMap.put(c1 + "", rootsTree);
		inputStream.close();
		return rootsTree;
	}

	/**
	 * الحصول على قائمة الجذور الرباعية المجردة حسب حرفها الأول
	 * 
	 * @param c1
	 *            char
	 * @return UnaugmentedQuadrilateralRootTree
	 */
	UnaugmentedQuadriliteralRootTree getUnaugmentedQuadrilateralRootTree(char c1) throws Exception {
		UnaugmentedQuadriliteralRootTree rootsTree = quadrilateralUnaugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		rootsTree = UnaugmentedQuadriliteralRootTreeCreator
				.buildXmlVerbTree(getResourceInputStream("db/quadriliteral/unaugmented/" + c1 + ".xml"));
		quadrilateralUnaugmentedTreeMap.put(c1 + "", rootsTree);
		return rootsTree;
	}

	/**
	 * الحصول على قائمة الجذور الرباعية المزيدة حسب حرفها الأول
	 * 
	 * @param c1
	 *            char
	 * @return AugmentedQuadrilateralRootTree
	 */
	AugmentedQuadriliteralRootTree getAugmentedQuadrilateralRootTree(char c1) throws Exception {
		AugmentedQuadriliteralRootTree rootsTree = quadrilateralAugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		var resourceName = String.format("db/quadriliteral/augmented/%s.xml", c1);
		var inputStream = getResourceInputStream(resourceName);
		rootsTree = AugmentedQuadriliteralRootTreeCreator
				.buildXmlVerbTree(inputStream);
		quadrilateralAugmentedTreeMap.put(c1 + "", rootsTree);
		inputStream.close();
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
		Map<String, XmlNounFormulaTree> folderMap = allNounsTreeMap.computeIfAbsent(folderName, k -> new HashMap<>());

		XmlNounFormulaTree formulaTree = folderMap.get(c1 + "");
		if (formulaTree != null)
			return formulaTree;

		var resourceName = String.format("db/noun/%s/%s.xml", folderName, c1);
		var inputStream = getResourceInputStream(resourceName);
		if (inputStream == null)
			// there is no applied file for this char
			throw new FileNotFoundException(resourceName + " was not found.");

		formulaTree = XmlNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
		folderMap.put(c1 + "", formulaTree);
		inputStream.close();
		return formulaTree;
	}

	public XmlMeemGerundNounFormulaTree getMeemGerundFormulaTree(char c1) throws Exception {
		XmlMeemGerundNounFormulaTree formulaTree = meemGerundMap.get(c1 + "");
		if (formulaTree != null)
			return formulaTree;

		var resourceName = String.format("db/gerund/meem/%s.xml", c1);
		var inputStream = getResourceInputStream(resourceName);
		if (inputStream == null)
			// there is no applied inputStream for this char
			return null;

		formulaTree = XmlMeemGerundNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
		meemGerundMap.put(c1 + "", formulaTree);
		inputStream.close();
		return formulaTree;
	}

	public AssimilateAdjectiveFormulaTree getAssimilateAdjectiveFormulaTree(char c1) {
		AssimilateAdjectiveFormulaTree formulaTree = assimilateAdjectiveMap.get(c1 + "");
		if (formulaTree == null) {
			try {
				var inputStream = getResourceInputStream("db/noun/assimilate/" + c1 + ".xml");
				if (null == inputStream)
					// there is no applied inputStream for this char
					return null;
				formulaTree = AssimilateAdjectiveFormulaTreeCreator.buildNounFormulaTree(inputStream);
				assimilateAdjectiveMap.put(c1 + "", formulaTree);
				inputStream.close();
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
				var inputStream = getResourceInputStream("db/noun/elative/" + c1 + ".xml");
				if (null == inputStream)
					// there is no applied inputStream for this char
					return null;
				formulaTree = ElativeNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
				elativeNounMap.put(c1 + "", formulaTree);
				inputStream.close();
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
				var inputStream = getResourceInputStream("db/noun/instrumental/" + c1 + ".xml");
				if (null == inputStream)
					// there is no applied inputStream for this char
					return null;
				formulaTree = XmlNonStandardInstrumentalNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
				instrumentalNounMap.put(c1 + "", formulaTree);
				inputStream.close();
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
				var inputStream = getResourceInputStream("db/noun/exaggeration/" + c1 + ".xml");
				if (null == inputStream )
					// there is no applied file for this char
					return null;
				formulaTree = XmExaggerationNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
				exaggerationNounMap.put(c1 + "", formulaTree);
				inputStream.close();
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
				var inputStream = getResourceInputStream("db/noun/timeandplace/" + c1 + ".xml");
				if (inputStream == null)
					// there is no applied file for this char
					return null;
				formulaTree = XmlTimeAndPlaceNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
				timeAndPlaceNounMap.put(c1 + "", formulaTree);
				inputStream.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return formulaTree;
	}
}
