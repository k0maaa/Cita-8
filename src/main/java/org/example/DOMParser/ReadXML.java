package org.example.DOMParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("C:\\Users\\AsusVivo\\IdeaProjects\\sito_i_ris_7\\src\\main\\resources\\Vehicles.xml"));
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            NodeList vehicleList = root.getChildNodes();
            for (int i = 0; i < vehicleList.getLength(); i++) {
                Node node = vehicleList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element vehicle = (Element) node;
                    if (vehicle.getNodeName().equals("car")) {
                        printCarInfo(vehicle);
                    } else if (vehicle.getNodeName().equals("plane")) {
                        printPlaneInfo(vehicle);
                    }
                    else {
                        printBoatInfo(vehicle);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printCarInfo(Element car) {
        String vendor = car.getElementsByTagName("vendor").item(0).getTextContent();
        String model = car.getElementsByTagName("model").item(0).getTextContent();
        String color = car.getElementsByTagName("color").item(0).getTextContent();
        String price = car.getElementsByTagName("price").item(0).getTextContent();
        String year = car.getElementsByTagName("year").item(0).getTextContent();
        String engine = car.getElementsByTagName("engine").item(0).getTextContent();
        String doors = car.getElementsByTagName("doors").item(0).getTextContent();

        System.out.println("Car:");
        System.out.println("  Vendor: " + vendor);
        System.out.println("  Model: " + model);
        System.out.println("  Color: " + color);
        System.out.println("  Price: " + price);
        System.out.println("  Year: " + year);
        System.out.println("  Engine: " + engine);
        System.out.println("  Doors: " + doors);
        System.out.println("-----------------------------------");
    }
    public static void printPlaneInfo(Element plane) {
        String vendor = plane.getElementsByTagName("vendor").item(0).getTextContent();
        String model = plane.getElementsByTagName("model").item(0).getTextContent();
        String color = plane.getElementsByTagName("color").item(0).getTextContent();
        String price = plane.getElementsByTagName("price").item(0).getTextContent();
        String year = plane.getElementsByTagName("year").item(0).getTextContent();
        String engines = plane.getElementsByTagName("engines").item(0).getTextContent();
        String seats = plane.getElementsByTagName("seats").item(0).getTextContent();

        System.out.println("Plane:");
        System.out.println("  Vendor: " + vendor);
        System.out.println("  Model: " + model);
        System.out.println("  Color: " + color);
        System.out.println("  Price: " + price);
        System.out.println("  Year: " + year);
        System.out.println("  Engines: " + engines);
        System.out.println("  Seats: " + seats);
        System.out.println("-----------------------------------");
    }
    public static void printBoatInfo(Element boat) {
        String vendor = boat.getElementsByTagName("vendor").item(0).getTextContent();
        String model = boat.getElementsByTagName("model").item(0).getTextContent();
        String color = boat.getElementsByTagName("color").item(0).getTextContent();
        String price = boat.getElementsByTagName("price").item(0).getTextContent();
        String year = boat.getElementsByTagName("year").item(0).getTextContent();
        String has_motor = boat.getElementsByTagName("has_motor").item(0).getTextContent();
        String has_sail = boat.getElementsByTagName("has_sail").item(0).getTextContent();

        System.out.println("Boat:");
        System.out.println("  Vendor: " + vendor);
        System.out.println("  Model: " + model);
        System.out.println("  Color: " + color);
        System.out.println("  Price: " + price);
        System.out.println("  Year: " + year);
        System.out.println("  Has motor: " + has_motor);
        System.out.println("  Has sail: " + has_sail);
        System.out.println("-----------------------------------");
    }
}
