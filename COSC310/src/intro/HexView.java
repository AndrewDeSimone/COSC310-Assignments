package intro;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;

public class HexView {
    public static void main(String[] args) {
        //Get the filename
        System.out.print("Enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        try (InputStream in = new FileInputStream(fileName)) {
            int offset = 0;
            int b;
            while((b = in.read()) != -1) {
                if (offset % 16 == 0) {
                    System.out.printf("%08x: ", offset);
                }
                System.out.printf("%02x ", b);
                offset++;
                if (offset % 16 == 0) {
                    System.out.println();
                }
            }
            if (offset %16 != 0) {
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
