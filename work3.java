import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class work3 
{
    public static void main(String[] args)
    {

        try 
        {
            dataRequest();
            System.out.println("success");
        }catch (FileSystemException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    public static void dataRequest() throws Exception
    {
        System.out.println("Введите: фамилию, имя, отчество,\n" +
        "дату рождения (в формате dd.mm.yyyy),\n" +
        "номер телефона (число без разделителей),\n" + 
        "пол(символ латиницей f или m), разделенные пробелом");
        System.out.print("Ввод -> ");
        String text;
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) 
        {
            text = bf.readLine();
        }catch (IOException e)
        {
            throw new Exception("Произошла ошибка при работе с консолью");
        }

        String[] array = text.split(" ");
        if (array.length != 6)
        {
            throw new Exception("Введено неверное количество параметров");
        }

        String surname = array[0];
        String name = array[1];
        String patronymic = array[2];

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdays;
        try 
        {
            birthdays = format.parse(array[3]);
        }catch (ParseException e)
        {
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

        int phone;
        try 
        {
            phone = Integer.parseInt(array[4]);
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Неверный формат телефона");
        }

        String sex = array[5];
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f"))
        {
            throw new RuntimeException("Неверно введен пол");
        }

        String naming = surname.toLowerCase() + ".txt";
        File file = new File(naming);
        try (FileWriter fileWriter = new FileWriter(file, true))
        {
            if (file.length() > 0)
            {
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patronymic, format.format(birthdays), phone, sex));
        }catch (IOException e)
        {
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }

    }
}