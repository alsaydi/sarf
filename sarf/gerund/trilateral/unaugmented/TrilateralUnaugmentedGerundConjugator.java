package sarf.gerund.trilateral.unaugmented;

import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import org.apache.commons.digester3.Digester;
import java.io.File;
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
public class TrilateralUnaugmentedGerundConjugator implements IUnaugmentedTrilateralGerundConjugator {
    private static TrilateralUnaugmentedGerundConjugator instance = new TrilateralUnaugmentedGerundConjugator();
    private GerundDescriptionList gerundDescriptionList;

    private TrilateralUnaugmentedGerundConjugator() {
        try {
            gerundDescriptionList = build(new File("./db/gerund/GerundDescription.xml"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static TrilateralUnaugmentedGerundConjugator getInstance() {
        return instance;
    }

    private GerundDescriptionList build(File xmlFile) throws Exception {
        Digester digester = new Digester();
        digester.setValidating(false);

        digester.addObjectCreate("gerunds", GerundDescriptionList.class);

        digester.addObjectCreate("gerunds/gerund", GerundDescription.class);
        digester.addSetProperties("gerunds/gerund", "symbol", "symbol");
        digester.addSetProperties("gerunds/gerund", "pattern", "pattern");

        digester.addSetNext("gerunds/gerund", "addGerundDescription");

        return (GerundDescriptionList) digester.parse(xmlFile);
    }

    public List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

    public List createGerundList(UnaugmentedTrilateralRoot root, String pattern) {
        GerundDescription gerundDescription = gerundDescriptionList.getGerundDescriptionByPattern(pattern);
        Gerund gerund = root.getGerund(gerundDescription.getSymbol());

        List gerundDisplayList = createEmptyList();
        String gerundText = StandardTrilateralUnaugmentedSuffixContainer.getInstance().getPrefix() + gerund.getValue();
        //ÝÍÕ æÇÐÇ äÌÍ ÇáÇÎÊÈÇÑ Êßæä ÇáÞÇÆãÉ ÌÇåÒÉ
        if (isSpecialCase(gerundText, gerundDisplayList, gerundDescription)) {
            return gerundDisplayList;
        }

        //ÇáÍÇáÉ ÇáÚÇãÉ
        if (gerundDescription.isFeminine()) {
            gerundDisplayList.set(1, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(1));
            gerundDisplayList.set(7, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(7));
            gerundDisplayList.set(13, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(13));
        }
        else {
            gerundDisplayList.set(0, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(0));
            gerundDisplayList.set(6, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(6));
            gerundDisplayList.set(12, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(12));
        }
        return gerundDisplayList;
    }

    private boolean isSpecialCase(String gerundText, List gerundDisplayList, GerundDescription gerundDescription) {
        if (StandardTrilateralUnaugmentedSuffixContainer.getInstance().isIndefinite()) {
            if (gerundText.endsWith("óì") || gerundText.endsWith("øóì") || gerundText.endsWith("íóÇ")) {
                //áÇ ÊÖíÝ Ãí ÔíÁ
                if (gerundDescription.isFeminine()) {
                    gerundDisplayList.set(1, gerundText);
                    gerundDisplayList.set(7, gerundText);
                    gerundDisplayList.set(13, gerundText);
                }
                else {
                    gerundDisplayList.set(0, gerundText);
                    gerundDisplayList.set(6, gerundText);
                    gerundDisplayList.set(12, gerundText);

                }
                return true;
            }

            if (!gerundDescription.isFeminine()) {
                if (gerundText.endsWith("ÇÁ") || gerundText.endsWith("óÃ")) {
                    gerundDisplayList.set(0, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(0));
                    //ÇÖÇÝÉ ÝÞØ ÇáÊäæíä
                    gerundDisplayList.set(6, gerundText + "ð");
                    gerundDisplayList.set(12, gerundText + StandardTrilateralUnaugmentedSuffixContainer.getInstance().get(12));
                    return true;
                }
                else if (gerundText.endsWith("ðì") || gerundText.endsWith("ðÇ") || gerundText.endsWith("áÇð")) {
                    //áÇ ÊÖíÝ Ãí ÔíÁ
                    gerundDisplayList.set(0, gerundText);
                    gerundDisplayList.set(6, gerundText);
                    gerundDisplayList.set(12, gerundText);
                    return true;
                }
            }

        }
        //ãÚÇáÌÉ ÇáÇÖÇÝÉ æÇáãÚÑÝÉ
        else {
            if (gerundText.endsWith("óì") || gerundText.endsWith("øóì") || gerundText.endsWith("íóÇ")) {
                //áÇ ÊÖíÝ Ãí ÔíÁ
                if (gerundDescription.isFeminine()) {
                    gerundDisplayList.set(1, gerundText);
                    gerundDisplayList.set(7, gerundText);
                    gerundDisplayList.set(13, gerundText);
                }
                else {
                    gerundDisplayList.set(0, gerundText);
                    gerundDisplayList.set(6, gerundText);
                    gerundDisplayList.set(12, gerundText);

                }
                return true;
            }

            if (!gerundDescription.isFeminine()) {
                if (gerundText.endsWith("ðì") || gerundText.endsWith("ðÇ") || gerundText.endsWith("áÇð")) {
                    //áÇ ÊÖíÝ Ãí ÔíÁ
                    //ÊÓÊÈÏá ÇáÊäæíä ÈÝÊÍÉ
                    String text = gerundText.replaceAll("ð", "ó");
                    gerundDisplayList.set(0, text);
                    gerundDisplayList.set(6, text);
                    gerundDisplayList.set(12, text);
                    return true;
                }
            }
        }

        return false;
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        Iterator iter = root.getGerundsSymbols().iterator();
        while (iter.hasNext()) {
            String symbol = (String) iter.next();
            GerundDescription gerundDescription = gerundDescriptionList.getGerundDescriptionBySymbol(symbol);
            result.add(gerundDescription.getPattern());
        }
        return result;
    }

}
