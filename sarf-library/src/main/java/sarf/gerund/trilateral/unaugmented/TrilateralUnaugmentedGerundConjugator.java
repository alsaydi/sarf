package sarf.gerund.trilateral.unaugmented;

import com.google.inject.Inject;
import org.apache.commons.digester3.Digester;
import sarf.Gerund;
import sarf.SystemConstants;
import sarf.Word;
import sarf.util.FileUtil;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private static List<Word> createEmptyList() {
        return IntStream.rangeClosed(1, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> Word.empty())
                .collect(Collectors.toCollection(() -> new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES)));
    }

    public List<Word> createGerundList(UnaugmentedTrilateralRoot root, String pattern) {
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
            gerundDisplayList.set(1, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(1)));
            gerundDisplayList.set(7, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(7)));
            gerundDisplayList.set(13, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(13)));
        } else {
            gerundDisplayList.set(0, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(0)));
            gerundDisplayList.set(6, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(6)));
            gerundDisplayList.set(12, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(12)));
        }
        return gerundDisplayList;
    }

    private boolean isSpecialCase(String gerundText, List<Word> gerundDisplayList, GerundDescription gerundDescription) {
        final boolean endsWithYa = gerundText.endsWith("َى") || gerundText.endsWith("َّى") || gerundText.endsWith("يَا");
        final boolean endsWithAlef = gerundText.endsWith("ًى") || gerundText.endsWith("ًا") || gerundText.endsWith("لاً");
        if (standardTrilateralUnaugmentedSuffixContainer.isIndefinite()) {
            if (endsWithYa) {
                //لا تضيف أي شيء
                if (gerundDescription.isFeminine()) {
                    gerundDisplayList.set(1, Word.fromString(gerundText));
                    gerundDisplayList.set(7, Word.fromString(gerundText));
                    gerundDisplayList.set(13, Word.fromString(gerundText));
                } else {
                    gerundDisplayList.set(0, Word.fromString(gerundText));
                    gerundDisplayList.set(6, Word.fromString(gerundText));
                    gerundDisplayList.set(12, Word.fromString(gerundText));
                }
                return true;
            }

            if (!gerundDescription.isFeminine()) {
                if (gerundText.endsWith("اء") || gerundText.endsWith("َأ")) {
                    gerundDisplayList.set(0, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(0)));
                    //اضافة فقط التنوين
                    gerundDisplayList.set(6, Word.fromString(gerundText + "ً"));
                    gerundDisplayList.set(12, Word.fromString(gerundText + standardTrilateralUnaugmentedSuffixContainer.get(12)));
                    return true;
                } else if (endsWithAlef) {
                    //لا تضيف أي شيء
                    gerundDisplayList.set(0, Word.fromString(gerundText));
                    gerundDisplayList.set(6, Word.fromString(gerundText));
                    gerundDisplayList.set(12, Word.fromString(gerundText));
                    return true;
                }
            }

        }
        //معالجة الاضافة والمعرفة
        else {
            if (endsWithYa) {
                //لا تضيف أي شيء
                if (gerundDescription.isFeminine()) {
                    gerundDisplayList.set(1, Word.fromString(gerundText));
                    gerundDisplayList.set(7, Word.fromString(gerundText));
                    gerundDisplayList.set(13, Word.fromString(gerundText));
                } else {
                    gerundDisplayList.set(0, Word.fromString(gerundText));
                    gerundDisplayList.set(6, Word.fromString(gerundText));
                    gerundDisplayList.set(12, Word.fromString(gerundText));

                }
                return true;
            }

            if (!gerundDescription.isFeminine()) {
                if (endsWithAlef) {
                    //لا تضيف أي شيء
                    //تستبدل التنوين بفتحة
                    String text = gerundText.replaceAll("ً", "َ");
                    gerundDisplayList.set(0, Word.fromString(gerundText));
                    gerundDisplayList.set(6, Word.fromString(gerundText));
                    gerundDisplayList.set(12, Word.fromString(gerundText));
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
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
