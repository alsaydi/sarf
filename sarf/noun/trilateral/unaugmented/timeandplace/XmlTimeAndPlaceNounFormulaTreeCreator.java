package sarf.noun.trilateral.unaugmented.timeandplace;

import org.apache.commons.digester.*;
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
public class XmlTimeAndPlaceNounFormulaTreeCreator {
    private XmlTimeAndPlaceNounFormulaTreeCreator() {
    }

    public static XmlTimeAndPlaceNounFormulaTree buildNounFormulaTree(File xmlDiagramFile) throws Exception{
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("formulas", XmlTimeAndPlaceNounFormulaTree.class );

        digester.addObjectCreate("formulas/formula", XmlTimeAndPlaceNounFormula.class );
        digester.addSetProperties("formulas/formula", "c1","c1" );
        digester.addSetProperties("formulas/formula", "c2","c2" );
        digester.addSetProperties("formulas/formula", "c3", "c3" );
        digester.addSetProperties("formulas/formula", "noc", "noc" );
        digester.addSetProperties("formulas/formula", "form1", "form1" );
        digester.addSetProperties("formulas/formula", "form2", "form2" );


        digester.addSetNext( "formulas/formula" , "addFormula" );

        return (XmlTimeAndPlaceNounFormulaTree)digester.parse(xmlDiagramFile);
    }

}
