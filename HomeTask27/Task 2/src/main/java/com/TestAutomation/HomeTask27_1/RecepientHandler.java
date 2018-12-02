package com.TestAutomation.HomeTask27_1;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RecepientHandler extends DefaultHandler {

	private List<Recepient> recepients;
    private Recepient recepient;
    boolean bAddress = false;
    boolean bName = false;
   
    public List<Recepient> getRecepients()
    {
        return recepients;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {

        if (qName.equalsIgnoreCase("Recepient"))
        {
            String id = attributes.getValue("id");
            recepient = new Recepient();
            recepient.setId(Integer.parseInt(id));
            if (recepients == null)
            {
            	recepients = new ArrayList<>();
            }
        }
        else if (qName.equalsIgnoreCase("Address"))
        {
            bAddress = true;
        }
        else if (qName.equalsIgnoreCase("name"))
        {
            bName = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equalsIgnoreCase("Recepient"))
        {
        	recepients.add(recepient);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException
    {

        if (bAddress)
        {
        	recepient.setAddress(new String(ch, start, length));
            bAddress = false;
        }
        else if (bName)
        {
        	recepient.setName(new String(ch, start, length));
            bName = false;
        }
    }
}
