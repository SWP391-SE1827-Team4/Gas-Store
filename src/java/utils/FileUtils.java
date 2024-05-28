/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public static boolean isImageFile(InputStream inputStream) throws IOException {
        byte[] header = new byte[8];
        int bytesRead = inputStream.read(header);

        // Đọc đủ 8 byte đầu tiên của file
        if (bytesRead < 8) {
            return false;
        }
//        
//        // Kiểm tra magic number của các định dạng ảnh phổ biến
//        if (isJpeg(header) || isPng(header) || isGif(header) || isBmp(header)) {
//            return true;
//        }
//        
        return true;
    }
    
    private static boolean isJpeg(byte[] header) {
        return (header[0] == (byte) 0xFF) && (header[1] == (byte) 0xD8);
    }
    
    private static boolean isPng(byte[] header) {
        return (header[0] == (byte) 0x89 && header[1] == (byte) 0x50 &&
                header[2] == (byte) 0x4E && header[3] == (byte) 0x47 &&
                header[4] == (byte) 0x0D && header[5] == (byte) 0x0A &&
                header[6] == (byte) 0x1A && header[7] == (byte) 0x0A);
    }
    
    private static boolean isGif(byte[] header) {
        return (header[0] == (byte) 0x47 && header[1] == (byte) 0x49 &&
                header[2] == (byte) 0x46 && header[3] == (byte) 0x38) ||
                (header[0] == (byte) 0x47 && header[1] == (byte) 0x49 &&
                header[2] == (byte) 0x46 && header[3] == (byte) 0x38 &&
                header[4] == (byte) 0x39 && header[5] == (byte) 0x61);
    }
    
    private static boolean isBmp(byte[] header) {
        return (header[0] == (byte) 0x42 && header[1] == (byte) 0x4D);
    }
}