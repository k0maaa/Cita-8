package org.example.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class XPathExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\Vehicles.xml"));

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            XPathExpression xPathExpression = xPath.compile("//vehicles/descendant::car[price >= 20000 and doors = 4]");
            NodeList carsList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

            System.out.println("Cars that have 4 doors and cost more than 20000");
            System.out.println("-----------------------------------------------");
            for (int i = 0; i < carsList.getLength(); i++) {
                System.out.println("Vendor: " + xPath.evaluate("vendor", carsList.item(i)));
                System.out.println("Model: " + xPath.evaluate("model", carsList.item(i)));
                System.out.println("Color: " + xPath.evaluate("color", carsList.item(i)));
                System.out.println("Price: " + xPath.evaluate("price", carsList.item(i)));
                System.out.println("Year: " + xPath.evaluate("year", carsList.item(i)));
                System.out.println("Engine: " + xPath.evaluate("engine", carsList.item(i)));
                System.out.println("Doors: " + xPath.evaluate("doors", carsList.item(i)));
                System.out.println("----------------------------------");
            }

            xPathExpression = xPath.compile("count(//car)");
            double carCount = (double) xPathExpression.evaluate(document, XPathConstants.NUMBER);
            xPathExpression = xPath.compile("count(//plane)");
            double planeCount = (double) xPathExpression.evaluate(document, XPathConstants.NUMBER);
            xPathExpression = xPath.compile("count(//boat)");
            double boatCount = (double) xPathExpression.evaluate(document, XPathConstants.NUMBER);
            xPathExpression = xPath.compile("sum(//car/price)");
            double carsTotalPrice = (double) xPathExpression.evaluate(document, XPathConstants.NUMBER);

            System.out.println("Total amount of cars in file = " + carCount);
            System.out.println("Total amount of planes in file = " + planeCount);
            System.out.println("Total amount of boats in file = " + boatCount);
            System.out.println("Total price of all cars in file = " + carsTotalPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
