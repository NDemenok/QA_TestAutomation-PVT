package com.TestAutomation.HomeTask27_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Run {

	 private static final String RECEPIENTS_XML = "Recepients.xml";

	    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
	            XMLStreamException
	    {
	        System.out.println(" ========================= SAX parser ==============================");
	        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	        SAXParser saxParser = saxParserFactory.newSAXParser();
	        RecepientHandler recepientHandler = new RecepientHandler();
	        saxParser.parse(new File(RECEPIENTS_XML), recepientHandler);
	        List<Recepient> recepients = recepientHandler.getRecepients();
	        recepients.forEach(recepient -> System.out.println(recepient));

	        System.out.println(" ============================== STAX parser =========================");
	        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
	        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(RECEPIENTS_XML));
	        recepients = new StaxParser().parse(xmlEventReader);
	        recepients.forEach(recepient -> System.out.println(recepient));

	        System.out.println(" ============================== DOM parser =========================");
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document document = dBuilder.parse(RECEPIENTS_XML);
	        recepients = new DomParser().parse(document);
	        recepients.forEach(recepient -> System.out.println(recepient));
	    }
}
