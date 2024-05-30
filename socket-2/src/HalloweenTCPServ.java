import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
// ユーティリティパッケージを利用する

public class HalloweenTCPServ {

    /*
     * メイン・メソッド 接続要求のあったクライアントに対して接続を行い クライアントから送られるメッセージを受信し、その内容を元に 変更された何らかなの結果をクライアントに対して送信する
     */
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            ServerSocket server = new ServerSocket(5002); // ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("server is waiting halloweenpresent at 5002");

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("connected");

            /* 年齢を受信する */
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


            HalloweenGhoast halloweenGhoast = (HalloweenGhoast) ois.readObject();// Integerクラスでキャスト。


            String msgPresent = halloweenGhoast.getGhoast();
            System.out.println("受け取ったpresentのメッセージは" + msgPresent);
            String presentfromClinet = halloweenGhoast.getPresent();
            System.out.println("presentはメッセージは" + presentfromClinet);

            halloweenGhoast.printGhoastinfo();
            halloweenGhoast.changeGhoastype();
            halloweenGhoast.swapFromTo();


            // halloweenpresent.from="サーバ";

            /* 判定結果をクライアントに送信する */
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());


            // HalloweenGhoast present2 = new HalloweenGhoast();
            // present2.setGhoast("サバです。ハッピーハロウィーン");
            // present2.setPresent("豪華なもの");

            oos.writeObject(halloweenGhoast);
            oos.flush();


            // close処理

            oos.close();
            ois.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("エラーが発生したのでプログラムを終了します");
        }
    }// main end

}// HalloweenTCPServ end
