package sarf.noun.trilateral.unaugmented.assimilate;

import org.apache.commons.digester3.*;
import java.io.*;

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
public class AssimilateAdjectiveFormulaTreeCreator {
    private AssimilateAdjectiveFormulaTreeCreator() {
    }

    public static AssimilateAdjectiveFormulaTree buildNounFormulaTree(File xmlDiagramFile) throws Exception{
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("formulas", AssimilateAdjectiveFormulaTree.class );

        digester.addObjectCreate("formulas/formula", AssimilateAdjectiveFormula.class );
        digester.addSetProperties("formulas/formula", "c1","c1" );
        digester.addSetProperties("formulas/formula", "c2","c2" );
        digester.addSetProperties("formulas/formula", "c3", "c3" );
        digester.addSetProperties("formulas/formula", "conjugation", "conjugation" );
        digester.addSetProperties("formulas/formula", "adj1", "adj1" );
        digester.addSetProperties("formulas/formula", "adj2", "adj2" );
        digester.addSetProperties("formulas/formula", "adj3", "adj3" );


        digester.addSetNext( "formulas/formula" , "addFormula" );

        return (AssimilateAdjectiveFormulaTree)digester.parse(xmlDiagramFile);
    }

}
