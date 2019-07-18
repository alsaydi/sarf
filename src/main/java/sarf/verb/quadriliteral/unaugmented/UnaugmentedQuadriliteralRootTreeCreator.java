package sarf.verb.quadriliteral.unaugmented;


import java.io.File;
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Title: تحويل ملف المعطيات إلى قائمة الجذور الرباعية المجردة       </p>
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
    public static UnaugmentedQuadriliteralRootTree buildXmlVerbTree(InputStream inputStream) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("roots", UnaugmentedQuadriliteralRootTree.class );

        digester.addObjectCreate("roots/root", UnaugmentedQuadrilateralRoot.class );
        digester.addSetProperties("roots/root", "c1","c1" );
        digester.addSetProperties( "roots/root", "c2","c2" );
        digester.addSetProperties( "roots/root", "c3", "c3" );
        digester.addSetProperties( "roots/root", "c4", "c4" );
        digester.addSetProperties( "roots/root", "transitive","transitive" );

        digester.addSetNext( "roots/root" , "addRoot" );

        return (UnaugmentedQuadriliteralRootTree)digester.parse(inputStream);
    }

}
