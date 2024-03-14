package XuatFile;

import java.io.File;
import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Duong dan:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (deleteFile(file)) {
                System.out.println("Da xoa");
            } else {
                System.out.println("Khong xoa duoc.");
            }
        } else {
            System.out.println("Khong ton tai.");
        }

        scanner.close();
    }

    private static boolean deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    deleteFile(subFile);
                }
            }
        }
        return file.delete();
    }
}
