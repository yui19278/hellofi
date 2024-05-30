import java.io.Serializable;

public class ITask implements Serializable {


    int execNum = 0; 
    public void setExecNumber(int x){
        // クライアントで最初に計算させる数字を入力しておく関数
        execNum = x;
    }


    public void exec(){
        // サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。

        


    public int getResult(); // クライアントで結果を取り出す関数
}
