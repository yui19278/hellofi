package thread;

class MySleepingRunnable implements Runnable {
    private char threadChar;

    public MySleepingRunnable(char threadChar) {
        this.threadChar = threadChar;
    }

    @Override
    public void run() {
        for (int j = 1; j <= 100; j++) {
            System.out.println("Thread " + threadChar + ": " + j);
            try {
                Thread.sleep(100); // 100ミリ秒待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
