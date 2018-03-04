package sarf.kov;

import org.apache.commons.digester.*;
import java.io.*;
import java.util.*;

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
public class KovRulesManager {
    private TrilateralKovRuleList trilateralRulesList;
    private QuadrilateralKovRuleList quadrilateralRulesList;

    private static KovRulesManager instance = new KovRulesManager();

    public static KovRulesManager getInstance() {
        return instance;
    }

    private KovRulesManager() {
        try {
            trilateralRulesList = buildTrilateral(new File("./db/Trilateralkov.xml"));
            quadrilateralRulesList = buildQuadrilateral(new File("./db/Quadrilateralkov.xml"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private TrilateralKovRuleList buildTrilateral(File xmlFile) throws Exception{
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("rules", TrilateralKovRuleList.class );

        digester.addObjectCreate("rules/rule", TrilateralKovRule.class );
        digester.addSetProperties("rules/rule", "c1","c1" );
        digester.addSetProperties("rules/rule", "c2","c2" );
        digester.addSetProperties("rules/rule", "c3","c3" );
        digester.addSetProperties("rules/rule", "kov","kov" );
        digester.addSetProperties("rules/rule", "desc","desc" );
        digester.addSetProperties("rules/rule", "example","example" );

        digester.addSetNext( "rules/rule" , "addRule" );

        return (TrilateralKovRuleList)digester.parse(xmlFile);
    }

    private QuadrilateralKovRuleList buildQuadrilateral(File xmlFile) throws Exception{
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("rules", QuadrilateralKovRuleList.class );

        digester.addObjectCreate("rules/rule", QuadrilateralKovRule.class );
        digester.addSetProperties("rules/rule", "c1","c1" );
        digester.addSetProperties("rules/rule", "c2","c2" );
        digester.addSetProperties("rules/rule", "c3","c3" );
        digester.addSetProperties("rules/rule", "c4","c4" );
        digester.addSetProperties("rules/rule", "kov","kov" );
        digester.addSetProperties("rules/rule", "desc","desc" );
        digester.addSetProperties("rules/rule", "example","example" );

        digester.addSetNext( "rules/rule" , "addRule" );

        return (QuadrilateralKovRuleList)digester.parse(xmlFile);
    }


    /**
     * the rules is sorted according to its application, so the first applied rule
     * will be returned its kov
     * @param c1 char
     * @param c2 char
     * @param c3 char
     * @return int
     */
    public int getTrilateralKov(char c1, char c2, char c3) {
        TrilateralKovRule rule = getTrilateralKovRule(c1, c2, c3);
        return rule != null? rule.getKov(): -1;
    }

    public TrilateralKovRule getTrilateralKovRule(char c1, char c2, char c3) {
        Iterator iter = trilateralRulesList.getRules().iterator();
        while (iter.hasNext()) {
            TrilateralKovRule rule = (TrilateralKovRule) iter.next();
            if (rule.check(c1, c2, c3))
                return rule;
        }
        return null;
    }

    public int getQuadrilateralKov(char c1, char c2, char c3, char c4) {
        QuadrilateralKovRule rule = getQuadrilateralKovRule(c1, c2, c3 ,c4);
        return rule!= null? rule.getKov(): -1;
    }

    public QuadrilateralKovRule getQuadrilateralKovRule(char c1, char c2, char c3, char c4) {
        Iterator iter = quadrilateralRulesList.getRules().iterator();
        while (iter.hasNext()) {
            QuadrilateralKovRule rule = (QuadrilateralKovRule) iter.next();
            if (rule.check(c1, c2, c3, c4))
                return rule;
        }
        return null;
    }


    public static void main(String[] args) {
        char c1 = 'Í';
        char c2 = 'í';
        char c3 = 'Í';
        char c4 = 'í';
        System.out.println(""+ KovRulesManager.getInstance().getQuadrilateralKov(c1,c2,c3,c4));
    }

}
