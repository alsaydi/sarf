package sarf.verb.trilateral.unaugmented;


import java.io.File;
import org.apache.commons.digester3.*;
import sarf.*;

/**
 * <p>Title: تحويل ملف المعطيات إلى قائمة الجذور الثلاثية المجردة       </p>
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
public class UnaugmentedTrilateralRootTreeCreator {
    public UnaugmentedTrilateralRootTreeCreator() {
    }

    public static UnaugmentedTrilateralRootTree buildXmlVerbTree(File xmlDiagramFile) throws Exception{
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("roots", UnaugmentedTrilateralRootTree.class );

        digester.addObjectCreate("roots/root", UnaugmentedTrilateralRoot.class );
        digester.addSetProperties("roots/root", "c1","c1" );
        digester.addSetProperties( "roots/root", "c2","c2" );
        digester.addSetProperties( "roots/root", "c3", "c3" );
        digester.addSetProperties( "roots/root", "conjugation","conjugation" );
        digester.addSetProperties( "roots/root", "transitive","transitive" );

        digester.addObjectCreate("roots/root/gerund", Gerund.class );
        digester.addSetProperties( "roots/root/gerund", "symbol","symbol" );
        digester.addSetProperties( "roots/root/gerund", "value","value" );
        digester.addSetNext( "roots/root/gerund" , "addGerund" );

        digester.addSetNext( "roots/root" , "addRoot" );

        return (UnaugmentedTrilateralRootTree)digester.parse(xmlDiagramFile);
    }

    public static void main(String[] args) {
        try {
            char c1 = 'ظ';
            UnaugmentedTrilateralRootTree rootTree = buildXmlVerbTree(new File("c:/sarf/"+c1+".xml"));
            System.out.println("done");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
