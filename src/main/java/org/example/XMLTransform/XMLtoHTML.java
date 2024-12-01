package org.example.XMLTransform;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XMLtoHTML {
    private static final String XMLpath = "C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\Vehicles.xml";
    private static final String XSLTpath = "C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\Vehicles XSLT.xml";
    private static final String HTMLfile = "C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\XMLoutput.html";

    public static void main(String[] args) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File(XSLTpath)));
            transformer.transform(new StreamSource(new File(XMLpath)), new StreamResult(new File(HTMLfile)));
            System.out.println("HTML file for XML is created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
