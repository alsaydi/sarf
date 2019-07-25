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

	private final Map<String, UnaugmentedTrilateralRootTree> tripleUnaugmentedTreeMap = new HashMap<>();
	private final Map<String, AugmentedTrilateralRootTree> tripleAugmentedTreeMap = new HashMap<>();

	private final Map<String, UnaugmentedQuadriliteralRootTree> quadriliteralUnaugmentedTreeMap = new HashMap<>();
	private final Map<String, AugmentedQuadriliteralRootTree> quadriliteralAugmentedTreeMap = new HashMap<>();

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

		rootsTree = UnaugmentedTrilateralRootTreeCreator.buildXmlVerbTree(getResourceInputStream("db/trilateral/unaugmented/" + c1 + ".xml"));
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
	AugmentedTrilateralRootTree getAugmentedTrilateralRootTree(char c1) throws Exception {
		AugmentedTrilateralRootTree rootsTree = tripleAugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		var inputStream = getResourceInputStream("db/trilateral/augmented/" + c1 + ".xml");
		rootsTree = AugmentedTrilateralRootTreeCreator.buildXmlVerbTree(inputStream);
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
	UnaugmentedQuadriliteralRootTree getUnaugmentedQuadriliteralRootTree(char c1) throws Exception {
		UnaugmentedQuadriliteralRootTree rootsTree = quadriliteralUnaugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		rootsTree = UnaugmentedQuadriliteralRootTreeCreator
				.buildXmlVerbTree(getResourceInputStream("db/quadriliteral/unaugmented/" + c1 + ".xml"));
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
	AugmentedQuadriliteralRootTree getAugmentedQuadriliteralRootTree(char c1) throws Exception {
		AugmentedQuadriliteralRootTree rootsTree = quadriliteralAugmentedTreeMap.get(c1 + "");
		if (rootsTree != null)
			return rootsTree;

		rootsTree = AugmentedQuadriliteralRootTreeCreator
				.buildXmlVerbTree(getResourceInputStream("db/quadriliteral/augmented/" + c1 + ".xml"));
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
		Map<String, XmlNounFormulaTree> folderMap = allNounsTreeMap.computeIfAbsent(folderName, k -> new HashMap<>());

		XmlNounFormulaTree formulaTree = folderMap.get(c1 + "");
		if (formulaTree != null)
			return formulaTree;

		var inputStream = getResourceInputStream("db/noun/" + folderName + "/" + c1 + ".xml");
		if (inputStream == null)
			// there is no applied file for this char
			throw new FileNotFoundException(inputStream + " was not found.");

		formulaTree = XmlNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
		folderMap.put(c1 + "", formulaTree);
		return formulaTree;
	}

	public XmlMeemGerundNounFormulaTree getMeemGerundFormulaTree(char c1) throws Exception {
		XmlMeemGerundNounFormulaTree formulaTree = meemGerundMap.get(c1 + "");
		if (formulaTree != null)
			return formulaTree;

		var inputStream = getResourceInputStream("db/gerund/meem/" + c1 + ".xml");
		if (inputStream == null)
			// there is no applied inputStream for this char
			return null;

		formulaTree = XmlMeemGerundNounFormulaTreeCreator.buildNounFormulaTree(inputStream);
		meemGerundMap.put(c1 + "", formulaTree);
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
				var file = getResourceInputStream("db/noun/timeandplace/" + c1 + ".xml");
				if (file == null)
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

	private static InputStream getResourceInputStream(String relativePath) throws IOException {
		System.err.println("Retrieving " + relativePath + " from resources");
		var inputStream = ClassLoader.getSystemResource(relativePath).openStream();
		if(inputStream == null){
			throw new IOException("inputStream is null when trying to load " + relativePath);
		}
		return inputStream;
	}
}
