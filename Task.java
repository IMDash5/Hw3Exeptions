import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

public class Task{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста введите Имя Фамилию Отчество Дату рождения Номер телефона и Пол через пробел:");
        String UserData = sc.nextLine();
        data(UserData, " ");
    }
    public static void data(String a, String separator){
        String[] arrayofstrings = a.split(separator);
        if (arrayofstrings.length - 1 > 5){
            System.out.println("Вы ввели слишком много данных, попробуйте снова и не забудьте поставить пробел между ними");
            System.exit(0);
        }
        try{
            FileManagment(arrayofstrings);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы ввели недостаточно данных, попробуйте снова и не забудьте поставить пробел между ними");
        }
        catch (NumberFormatException e){
            System.out.println("Ваш номер телефона не должен содержать буквы и иные знаки");
        }
    }
    
    public static void FileManagment(String[] arg){
        try{
            File file = new File(arg[1] + ".txt");
            if (file.exists() != true){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            fw.write(arg[0] + " " + arg[1] + " " + arg[2]+ " " + arg[3]+ " " + Long.parseLong(arg[4]) + " " + arg[5] + "\n");
            fw.close();
        } catch(IOException e){
            System.out.println("Ошибка при создании файла: " + e);
        }
    } 
    
}