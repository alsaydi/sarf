package sarf.verb.quadriliteral.unaugmented;


import java.io.File;
import org.apache.commons.digester3.Digester;
import sarf.*;
import java.io.IOException;

/**
 * <p>Title:  ÕÊÌ· „·› «·„⁄ÿÌ«  ≈·Ï ﬁ«∆„… «·Ã–Ê— «·—»«⁄Ì… «·„Ã—œ…       </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UnaugmentedQuadriliteralRootTreeCreator {
    public UnaugmentedQuadriliteralRootTreeCreator() {
    }

    public static UnaugmentedQuadriliteralRootTree buildXmlVerbTree(File xmlDiagramFile) throws Exception, IOException{
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("roots", UnaugmentedQuadriliteralRootTree.class );

        digester.addObjectCreate("roots/root", UnaugmentedQuadriliteralRoot.class );
        digester.addSetProperties("roots/root", "c1","c1" );
        digester.addSetProperties( "roots/root", "c2","c2" );
        digester.addSetProperties( "roots/root", "c3", "c3" );
        digester.addSetProperties( "roots/root", "c4", "c4" );
        digester.addSetProperties( "roots/root", "transitive","transitive" );

        digester.addSetNext( "roots/root" , "addRoot" );

        return (UnaugmentedQuadriliteralRootTree)digester.parse(xmlDiagramFile);
    }

}
