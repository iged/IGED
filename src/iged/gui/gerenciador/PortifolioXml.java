/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui.gerenciador;

import iged.gui.TelaCadastroDeTarefaInterno;
import iged.gerenciadorAtividade.MetadadoAtividade;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Dorgi
 */
public class PortifolioXml {

    private static File dir;
    private static String xmlTutorial;
    static MetadadoAtividade p = new MetadadoAtividade();
    static MetadadoAtividade metadado = new MetadadoAtividade();
    static File tarefas = new File("C:\\Tarefas\\tarefas.xml");

    public PortifolioXml() {
        dir = new File("C:\\Tarefas");
        dir.mkdir();
    }

    public static String converter() {
        XStream xstream = new XStream(new DomDriver());

        TelaCadastroDeTarefa tc = new TelaCadastroDeTarefa();
        xstream.alias("portifolio", MetadadoAtividade.class);

        //metadado.setCont(Integer.parseInt(tc.getIdStr()));
        metadado.setTitulo(tc.getTituloStr());
        metadado.setId(tc.getIdStr());
        metadado.setAutor(tc.getAutorStr());
        metadado.setArea(tc.getAreaStr());

        xmlTutorial = xstream.toXML(metadado);
        System.out.println(xmlTutorial);
        //reconstruir um objeto a partir de um xml
        //Portifolio newPortifolio = (Portifolio) xstream.fromXML(xmlTutorial); 
        return xmlTutorial;
    }

    public static String atualizar() {
        
        return xmlTutorial;
    }

    public File getDir() {
        return dir;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public static String getXmlTutorial() {
        return xmlTutorial;
    }

    public void setXmlTutorial(String xmlTutorial) {
        this.xmlTutorial = xmlTutorial;
    }
}
