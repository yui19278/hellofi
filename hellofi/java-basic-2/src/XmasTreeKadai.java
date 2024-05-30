public class XmasTreeKadai {

    public static void main(String[] args) {
        int X = Integer.parseInt(args[0]);
        int Y = Integer.parseInt(args[1]);
        int Z = Integer.parseInt(args[2]);
        String str = args[3];


        System.out.println("Draw your own xmas tree with multi-loop!");

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < (X - i) / 2; j++) {
                if (i % 2 == 0) {
                    System.out.print(" ");
                    System.out.print(str);
                } else if (i % 2 == 1) {
                    System.out.print(str);
                    System.out.print(" ");
                }
            }
            if (i % 2 == 0) {
                System.out.print(" ");
            } else if (i % 2 == 1) {
                System.out.print(str + " ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X + 1 - (Z / 2); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < Z; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
