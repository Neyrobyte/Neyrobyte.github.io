import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AsciiArtConverter {

    public static void convertToAsciiArt(String imagePath, boolean green) {
        try {
            // Загрузка изображения
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Получение размеров изображения
            int width = image.getWidth();
            int height = image.getHeight();

            // Проход по каждому пикселю изображения
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Получение цвета пикселя
                    int pixel = image.getRGB(x, y);

                    // Получение альфа-канала (прозрачности)
                    int alpha = (pixel >> 24) & 0xff;

                    // Если пиксель прозрачный, выводим пробел, иначе - символ '■'
                    if (alpha == 0) {
                        System.out.print(" ");
                    } else {
                        if(green) {
                            System.out.print("\u001B[32m■");
                        }
                        else {
                            System.out.print("■");
                        }
                    }
                }
                // Переход на новую строку после завершения строки изображения
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке изображения или обработке аргументов: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("[Ошибка]:\nВведите путь до файла в формате:\n[dir1/dir2/file.png]\n\nПолное представление:\n[String path, boolean green]");
        }
        else if(args.length == 1) {
            String imagePath = args[0];
            convertToAsciiArt(imagePath, false);
        }
        else if(args.length == 2) {
            String imagePath = args[0];
            boolean green = Boolean.parseBoolean(args[1]);
            convertToAsciiArt(imagePath, false);
        }
        else {
            System.out.println("[Ошибка]: Ошибка при обработке аргументов");
        }
    }
}