/*
 * / package networking.udp;
 * 
 * import java.net.DatagramPacket; import java.net.DatagramSocket;
 * 
 * public class UDPServer { public static void main(String[] args) { DatagramSocket socket = null;
 * try { socket = new DatagramSocket(9876); byte[] receiveData = new byte[1024];
 * 
 * while (true) { // 受信パケットを作成 DatagramPacket receivePacket = new DatagramPacket(receiveData,
 * receiveData.length); socket.receive(receivePacket);
 * 
 * String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
 * System.out.println("受信: " + message); } } catch (Exception e) { e.printStackTrace(); } finally {
 * if (socket != null && !socket.isClosed()) { socket.close(); } } } }
 */
package networking.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server6A {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                // 受信パケットの準備
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                System.out.println("サーバーはクライアントからのメッセージを待っています...");

                // クライアントからのデータを受信
                socket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0,
                        receivePacket.getLength(), StandardCharsets.UTF_8);
                System.out.println("受信: " + clientMessage);

                // サーバーからの返信をユーザに入力させる
                Scanner scanner = new Scanner(System.in);
                System.out.print("返信を入力してください: ");
                String serverResponse = scanner.nextLine();
                sendData = serverResponse.getBytes(StandardCharsets.UTF_8);

                // クライアントのアドレスとポートを取得
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // 返信をクライアントに送信
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
