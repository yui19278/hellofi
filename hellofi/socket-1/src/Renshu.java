class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    // ここに続きを実装していく。
    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q) {
        if (p > q) {
            return -1;
        } else {
            int sum = 0;
            for (int i = p; i <= q; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public int sumFromArrayIndex(int[] a, int index) {
        if (index < 0 || index > 4) {
            return -1;
        } else {
            int sum = 0;
            for (int i = index; i < a.length; i++) {
                sum += a[i];
            }
            return sum;
        }
    }

    public int selectMaxValue(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public int selectMaxIndex(int[] a) {
        int max = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }

    public int selectMinIndex(int[] a) {
        int min = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    public int swapArrayElements(int[] p, int i, int j) {
        int hoge = p[i];
        p[i] = p[j];
        p[j] = hoge;
        return 0;

    }
    public int swapTwoArrays(int[] a, int[] b) {
        int[] hoge = a;
        a = b;
        b = hoge;
        return 0;
    }
}
