/*
 * package networking.udp;
 * 
 * import java.net.DatagramPacket; import java.net.DatagramSocket; import java.net.InetAddress;
 * 
 * public class UDPClient { public static void main(String[] args) { DatagramSocket socket = null;
 * try { socket = new DatagramSocket(); InetAddress serverAddress =
 * InetAddress.getByName("localhost"); String message = "Hello, server!"; byte[] sendData =
 * message.getBytes();
 * 
 * // 送信パケットを作成 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
 * serverAddress, 9876); socket.send(sendPacket); } catch (Exception e) { e.printStackTrace(); }
 * finally { if (socket != null && !socket.isClosed()) { socket.close(); } } } }
 */
package networking.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client6A {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // クライアントからのメッセージをユーザに入力させる
                System.out.print("送信メッセージを入力してください: ");
                String clientMessage = scanner.nextLine();
                sendData = clientMessage.getBytes(StandardCharsets.UTF_8);

                // メッセージをサーバに送信
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                socket.send(sendPacket);

                // サーバからの返信を受信
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String serverResponse = new String(receivePacket.getData(), 0,
                        receivePacket.getLength(), StandardCharsets.UTF_8);
                System.out.println("サーバからの返信: " + serverResponse);
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
