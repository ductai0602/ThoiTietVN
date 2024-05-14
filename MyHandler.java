package SAX;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	private boolean country = false;
	private String nhiet_do;
	private String do_am;
	private String gio;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equalsIgnoreCase("country")) {
			country = true;
		}else if(qName.equalsIgnoreCase("sun")) {
			String date = attributes.getValue("rise");
		}else if(qName.equalsIgnoreCase("feels_like")) {
			nhiet_do = attributes.getValue("value");
		}else if(qName.equalsIgnoreCase("humidity")) {
			do_am = attributes.getValue("value");
		}else if(qName.equalsIgnoreCase("speed")) {
			gio = attributes.getValue("value");
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if(qName.equalsIgnoreCase("sun")) {
//			System.out.println();
		}else if(qName.equalsIgnoreCase("feels_like")) {
//			System.out.println();
		}else if(qName.equalsIgnoreCase("humidity")) {
//			System.out.println();
		}else if(qName.equalsIgnoreCase("speed")) {
//			System.out.println();
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if(country) {
//			System.out.println("Quoc gia: "+new String(ch, start, length) + "\n");
			country = false;
		}
	}

    public String getTemperature() {
        return nhiet_do;
    }

    public String getHumidity() {
        return do_am;
    }

    public String getWindSpeed() {
        return gio;
    }
}
