package com.TestAutomation.HomeTask27_1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {

	public List<Recepient> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("Recepient");
		List<Recepient> recepients = new ArrayList<Recepient>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			recepients.add(getRecepient(nodeList.item(i)));
		}
		return recepients;
	}

	private static Recepient getRecepient(Node node) {
		Recepient recepient = new Recepient();
		Element element = (Element) node;
		recepient.setId(Integer.parseInt(element.getAttribute("id")));
		recepient.setAddress(getTagValue("Address", element));
		recepient.setName(getTagValue("Name", element));
		return recepient;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}
