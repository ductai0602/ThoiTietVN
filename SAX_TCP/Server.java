package SAX_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import SAX.MyHandler;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			while(true) {
				Socket s = serverSocket.accept();
				DataInputStream in = new DataInputStream(s.getInputStream());
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				String city = in.readUTF();
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();
				
				MyHandler handler = new MyHandler();
				
				saxParser.parse(new URL("https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=cabc9614649278ff314eb4f62e95942e&mode=xml").openStream(), handler);
				String nhiet_do, do_am, gio;
				nhiet_do = handler.getTemperature();
				do_am = handler.getHumidity();
				gio = handler.getWindSpeed();
				out.writeUTF("Nhiệt độ: "+nhiet_do+", độ ẩm: "+do_am+", tốc độ gió"+gio);
				s.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
