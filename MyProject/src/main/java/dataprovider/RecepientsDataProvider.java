package dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import businessobject.Recepient;

public class RecepientsDataProvider {

	private static final String RECEPIENTS_XML = "Recepients.xml";
	private final static Logger LOG = Logger.getLogger(RecepientsDataProvider.class);
	
	public List<Recepient> getRecepientData() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		List<Recepient> recepients = Collections.emptyList();
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(RECEPIENTS_XML);
			recepients = new RecepientsDataProvider().parse(document);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			LOG.error(String.format("Failed to parse %s file!", RECEPIENTS_XML));
		}
		return recepients;
	}

	public List<Recepient> parse(Document document) {
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
		recepient.setAddress(getTagValue("Address", element));
		return recepient;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}
