
import java.util.Random;

public class NetproLabMember {
    final int years = 15;
    final int Univmem = 110;
    final int Ntlbmem = 10;
    final int Univ_fe = 20;



    public void calculateProbabilities() {
        Random rand = new Random();
        double netlabper = 1;

        int[][] netlab = new int[years][3]; // 総数, 割合, 配属人数
        for (int i = 0; i < years; i++) {
            netlab[i][0] = Univmem + rand.nextInt(20) - 10;
            netlab[i][1] = netlab[i][0] * (Univ_fe + i + 1);
            netlab[i][2] = 10 + rand.nextInt(7) - 4;
        }

        for (int i = 0; i < years; i++) {
            System.out.print(netlab[i][0]);
            System.out.print(netlab[i][1]);
            System.out.print(netlab[i][2]);
        }
    }
}
