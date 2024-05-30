package thread;

public class ThreadMoveVisualization implements Runnable {


    private int threadNum;

    public ThreadMoveVisualization(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        for (int j = 1; j <= 30; j++) {
            for (int l = 0; l < threadNum; l++) {
                System.out.print(" ");
            }
            System.out.println(j);
            // String paddedNumber = String.format("%03d", j); // 数字を3桁になるように0でパディング
            // System.out.println(paddedNumber);
            // System.out.println("Thread " + threadNum + ": " + j);
            try {
                Thread.sleep(0); // 100ミリ秒待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
