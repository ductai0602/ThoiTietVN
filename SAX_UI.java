package SAX;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SAX_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cb_ThanhPho;
	private JButton btn_search;
	private JLabel lb_TocDoGio;
	private JLabel lb_doAm;
	private JLabel lb_NhietDo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SAX_UI frame = new SAX_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SAX_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thời tiết");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(143, 10, 143, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thành Phố: ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 83, 108, 38);
		contentPane.add(lblNewLabel_1);
		
		cb_ThanhPho = new JComboBox();
		cb_ThanhPho.setModel(new DefaultComboBoxModel(new String[] {"", "An Giang", "Bà Rịa-Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "TP. Hồ Chí Minh", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên - Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"}));
		cb_ThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb_ThanhPho.setBounds(127, 83, 228, 38);
		contentPane.add(cb_ThanhPho);
		
		lb_NhietDo = new JLabel("00");
		lb_NhietDo.setForeground(new Color(255, 255, 255));
		lb_NhietDo.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_NhietDo.setFont(new Font("Tahoma", Font.PLAIN, 90));
		lb_NhietDo.setBounds(10, 160, 252, 123);
		contentPane.add(lb_NhietDo);
		
		JLabel lblNewLabel_3 = new JLabel("Độ ẩm");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(27, 374, 95, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tốc độ gió");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(288, 374, 108, 38);
		contentPane.add(lblNewLabel_3_1);
		
		lb_doAm = new JLabel("00\r\n");
		lb_doAm.setForeground(new Color(255, 255, 255));
		lb_doAm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_doAm.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_doAm.setBounds(10, 410, 56, 49);
		contentPane.add(lb_doAm);
		
		JLabel lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(76, 410, 46, 49);
		contentPane.add(lblNewLabel_5);
		
		lb_TocDoGio = new JLabel("00\r\n");
		lb_TocDoGio.setForeground(new Color(255, 255, 255));
		lb_TocDoGio.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_TocDoGio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_TocDoGio.setBounds(266, 410, 64, 49);
		contentPane.add(lb_TocDoGio);
		
		JLabel lblNewLabel_5_1 = new JLabel("m/s");
		lblNewLabel_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(340, 410, 46, 49);
		contentPane.add(lblNewLabel_5_1);
		
		btn_search = new JButton("Tìm");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = cb_ThanhPho.getSelectedItem().toString();
				updateWeatherData(city);
			}
		});
		btn_search.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_search.setBounds(366, 84, 71, 38);
		contentPane.add(btn_search);
		
		JLabel lb_NhietDo_1 = new JLabel("℃");
		lb_NhietDo_1.setForeground(new Color(255, 255, 255));
		lb_NhietDo_1.setHorizontalAlignment(SwingConstants.LEFT);
		lb_NhietDo_1.setFont(new Font("Tahoma", Font.PLAIN, 90));
		lb_NhietDo_1.setBounds(268, 160, 118, 123);
		contentPane.add(lb_NhietDo_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Bai_java_school\\XML_with_Java\\src\\SAX\\sky.jpg"));
		lblNewLabel_2.setBounds(0, -85, 448, 603);
		contentPane.add(lblNewLabel_2);
	}

	private void updateWeatherData(String city) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();

            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=cabc9614649278ff314eb4f62e95942e&mode=xml";
            InputStream inputStream = new URL(url).openStream();
            saxParser.parse(inputStream, handler);


            lb_NhietDo.setText(handler.getTemperature());
            lb_doAm.setText(handler.getHumidity());
            lb_TocDoGio.setText(handler.getWindSpeed());
            lb_NhietDo.repaint();//cập nhật lại thông số
            lb_doAm.repaint();
            lb_TocDoGio.repaint();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
