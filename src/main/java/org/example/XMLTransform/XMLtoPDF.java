package org.example.XMLTransform;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;

public class XMLtoPDF {
    private static String PDFpath = "C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\XMLoutputPDF.pdf";
    private static String XSL_FOpath = "C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\Vehicles XSL-FO.xml";
    private static final String XMLpath = "C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\Vehicles.xml";

    public static void main(String[] args) {
        try {
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

            File pdfFile = new File(PDFpath);
            FileOutputStream out = new FileOutputStream(pdfFile);

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File(XSL_FOpath)));

            transformer.transform(new StreamSource(new File(XMLpath)), new SAXResult(fop.getDefaultHandler()));

            out.close();
            System.out.println("PDF for XML was created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
