package sarf.gerund.trilateral.unaugmented;

import com.google.inject.Inject;
import org.apache.commons.digester3.Digester;
import sarf.Gerund;
import sarf.SystemConstants;
import sarf.util.FileUtil;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
    private final StandardTrilateralUnaugmentedSuffixContainer standardTrilateralUnaugmentedSuffixContainer;
    private static GerundDescriptionList gerundDescriptionList;

    @Inject
    public TrilateralUnaugmentedGerundConjugator(StandardTrilateralUnaugmentedSuffixContainer standardTrilateralUnaugmentedSuffixContainer) {
        this.standardTrilateralUnaugmentedSuffixContainer = standardTrilateralUnaugmentedSuffixContainer;
        init();
    }

    private static List<String> createEmptyList() {
        List<String> result = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
        for (int i = 1; i <= SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add("");
        }
        return result;
    }

    public List createGerundList(UnaugmentedTrilateralRoot root, String pattern) {
        GerundDescription gerundDescription = gerundDescriptionList.getGerundDescriptionByPattern(pattern);
        Gerund gerund = root.getGerund(gerundDescription.getSymbol());

        var gerundDisplayList = createEmptyList();
        String gerundText = standardTrilateralUnaugmentedSuffixContainer.getPrefix() + gerund.getValue();
        //فحص واذا نجح الاختبار تكون القائمة جاهزة
        if (isSpecialCase(gerundText, gerundDisplayList, gerundDescription)) {
            return gerundDisplayList;
        }

        //الحالة العامة
        if (gerundDescription.isFeminine()) {
            gerundDisplayList.set(1, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(1));
            gerundDisplayList.set(7, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(7));
            gerundDisplayList.set(13, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(13));
        } else {
            gerundDisplayList.set(0, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(0));
            gerundDisplayList.set(6, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(6));
            gerundDisplayList.set(12, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(12));
        }
        return gerundDisplayList;
    }

    private boolean isSpecialCase(String gerundText, List<String> gerundDisplayList, GerundDescription gerundDescription) {
        if (standardTrilateralUnaugmentedSuffixContainer.isIndefinite()) {
            if (gerundText.endsWith("َى") || gerundText.endsWith("َّى") || gerundText.endsWith("يَا")) {
                //لا تضيف أي شيء
                if (gerundDescription.isFeminine()) {
                    gerundDisplayList.set(1, gerundText);
                    gerundDisplayList.set(7, gerundText);
                    gerundDisplayList.set(13, gerundText);
                } else {
                    gerundDisplayList.set(0, gerundText);
                    gerundDisplayList.set(6, gerundText);
                    gerundDisplayList.set(12, gerundText);
                }
                return true;
            }

            if (!gerundDescription.isFeminine()) {
                if (gerundText.endsWith("اء") || gerundText.endsWith("َأ")) {
                    gerundDisplayList.set(0, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(0));
                    //اضافة فقط التنوين
                    gerundDisplayList.set(6, gerundText + "ً");
                    gerundDisplayList.set(12, gerundText + standardTrilateralUnaugmentedSuffixContainer.get(12));
                    return true;
                } else if (gerundText.endsWith("ًى") || gerundText.endsWith("ًا") || gerundText.endsWith("لاً")) {
                    //لا تضيف أي شيء
                    gerundDisplayList.set(0, gerundText);
                    gerundDisplayList.set(6, gerundText);
                    gerundDisplayList.set(12, gerundText);
                    return true;
                }
            }

        }
        //معالجة الاضافة والمعرفة
        else {
            if (gerundText.endsWith("َى") || gerundText.endsWith("َّى") || gerundText.endsWith("يَا")) {
                //لا تضيف أي شيء
                if (gerundDescription.isFeminine()) {
                    gerundDisplayList.set(1, gerundText);
                    gerundDisplayList.set(7, gerundText);
                    gerundDisplayList.set(13, gerundText);
                } else {
                    gerundDisplayList.set(0, gerundText);
                    gerundDisplayList.set(6, gerundText);
                    gerundDisplayList.set(12, gerundText);

                }
                return true;
            }

            if (!gerundDescription.isFeminine()) {
                if (gerundText.endsWith("ًى") || gerundText.endsWith("ًا") || gerundText.endsWith("لاً")) {
                    //لا تضيف أي شيء
                    //تستبدل التنوين بفتحة
                    String text = gerundText.replaceAll("ً", "َ");
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
        List<String> result = new ArrayList<>();
        for (String symbol : root.getGerundsSymbols()) {
            GerundDescription gerundDescription = gerundDescriptionList.getGerundDescriptionBySymbol(symbol);
            result.add(gerundDescription.getPattern());
        }
        return result;
    }

    private static void init() {
        if (gerundDescriptionList != null) {
            return;
        }
        try {
            gerundDescriptionList = build(FileUtil.getResourceInputStream("db/gerund/GerundDescription.xml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static GerundDescriptionList build(InputStream inputStream) throws Exception {
        Digester digester = new Digester();
        digester.setValidating(false);

        digester.addObjectCreate("gerunds", GerundDescriptionList.class);

        digester.addObjectCreate("gerunds/gerund", GerundDescription.class);
        digester.addSetProperties("gerunds/gerund", "symbol", "symbol");
        digester.addSetProperties("gerunds/gerund", "pattern", "pattern");

        digester.addSetNext("gerunds/gerund", "addGerundDescription");
        return (GerundDescriptionList) digester.parse(inputStream);
    }
}
