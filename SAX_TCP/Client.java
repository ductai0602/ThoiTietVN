package SAX_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                Socket s = new Socket("localhost", 1234);
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                System.out.println("Nhập tên thành phố (hoặc gõ 'exit' để thoát): ");
                String city = sc.nextLine();
                if (city.equalsIgnoreCase("exit")) {
                    break; // Thoát vòng lặp nếu người dùng nhập 'exit'
                }

                out.writeUTF(city);
                String result = in.readUTF();
                System.out.println(result);

                s.close();
            }
            sc.close(); // Đóng Scanner sau khi vòng lặp kết thúc
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

