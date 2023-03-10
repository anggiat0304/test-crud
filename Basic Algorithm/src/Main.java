import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tinggiSegitiga = input.nextInt();

        for (int i = 0; i < tinggiSegitiga; i++) {
            for (int j = 1; j <= tinggiSegitiga-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}