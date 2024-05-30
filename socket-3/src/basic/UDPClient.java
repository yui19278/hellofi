package basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String message = "Hello, server!";
            byte[] sendData = message.getBytes();
            byte[] receiveData = new byte[1024];
            Scanner scanner = new Scanner(System.in);

            // メッセージを入力させる
            System.out.print("英単語を入力してください: ");
            String clientMessage = scanner.nextLine();
            sendData = clientMessage.getBytes();

            // 送信パケットを作成
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, serverAddress, 9877);
            socket.send(sendPacket);

            // 返信を受信
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String serverResponse =
                    new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("サーバからの返信: " + serverResponse);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
