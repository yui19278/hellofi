package thread;

public class ExThreadsMain {
    public static void main(String[] args) {
        Thread[] threads = new Thread[30]; // スレッドの配列を作成

        // スレッドを配列に追加し、それぞれのスレッドに異なる処理を割り当てる


        for (int i = 0; i < 30; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(new ThreadMoveVisualization(threadNum));// めちゃ大事
        }

        // すべてのスレッドを開始
        for (Thread thread : threads) {
            thread.start();
        }

        // すべてのスレッドの終了を待機
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads have finished.");
    }
}
