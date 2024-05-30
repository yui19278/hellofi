/*
 * クライアント： キーボードから読み込んだ文字列をサーバに送信し、 サーバから受信した内容をもとにサーバから返信されてくる結果をディスプレイに表示する
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
// ユーティリティパッケージを利用する

public class HalloweenTCPClient {

    /*
     * メイン・メソッド 指定されたサーバに対して接続を要求し、 接続されたらキーボードから読み込んだ年齢を送信し、 受信した飲酒可否の判定結果をディスプレイに表示する
     */
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            BufferedReader reader = // キーボードから接続するサーバ名を読み込む
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Server name(localhost or 133.27.....)? >");
            String serverName = reader.readLine();
            Socket socket = // 指定されたサーバの5000番ポートに接続を要求する
                    new Socket(serverName, 5002);

            /* キーボードから年齢を読み込む */
            System.out.print("Ghoast type? >");

            String lineStr = reader.readLine();

            /* サーバに年齢を送信する */
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            // intはobject型でないのでObject型であるIntergerクラスに変換する。


            HalloweenGhoast present = new HalloweenGhoast();
            int nofg = Integer.parseInt(lineStr);
            present.setGhoastype(nofg);
            present.setGhoast("halloweenおめでとう！" + lineStr);
            present.setPresent("キャンディ");


            oos.writeObject(present);
            oos.flush();

            /* サーバから判定結果を受信する */
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // String result = (String)ois.readObject();//返事を文字列型でキャストする。

            HalloweenGhoast okaeshiPresent = (HalloweenGhoast) ois.readObject();

            String replayMsg = okaeshiPresent.getGhoast();
            System.out.println("お返しのプレゼントについていたのメッセージは" + replayMsg);
            String replayPresent = okaeshiPresent.getPresent();
            System.out.println("お返しプレゼントは" + replayPresent);

            okaeshiPresent.printGhoastinfo();

            oos.close();
            ois.close();

            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (java.net.UnknownHostException uhe) {
            uhe.printStackTrace();
            System.err.println("送信先のサーバ名が間違っているのでプログラムを終了します");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
