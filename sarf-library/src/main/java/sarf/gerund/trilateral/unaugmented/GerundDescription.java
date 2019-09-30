package sarf.gerund.trilateral.unaugmented;

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
public class GerundDescription {
    private String symbol;
    private String pattern;
    private boolean feminine = false;

    private static final List<String> femininePatterns = new ArrayList<>();

    static {
        femininePatterns.add("فَعْلَى");
        femininePatterns.add("فُعْلَى");
        femininePatterns.add("فِعْلَى");
        femininePatterns.add("فِعِّيْلَى");
    }

    public GerundDescription() {
    }

    public String getPattern() {
        return pattern;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isFeminine() {
        return feminine;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
//        if (pattern.endsWith("ى") || pattern.endsWith("ة") || pattern.endsWith("اء"))
        if (pattern.endsWith("ة"))
            feminine = true;
        else {
            for (var femininePattern : femininePatterns) {
                if (femininePattern.equals(pattern)) {
                    feminine = true;
                    break;
                }
            }
        }
    }
}
