package basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9877);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            // 受信パケットの準備
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("サーバーはクライアントからのメッセージを待っています...");

            // クライアントからのデータを受信
            socket.receive(receivePacket);
            String clientMessage =
                    new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("受信: " + clientMessage);

            // 大文字小文字への変換
            String serverResponse = clientMessage.toUpperCase();

            sendData = serverResponse.getBytes();

            // クライアントのアドレスとポートを取得
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // 返信をクライアントに送信
            DatagramPacket sendPacket2 =
                    new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket2);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
