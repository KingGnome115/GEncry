package clases;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Kevin
 */
public class Metodos
{

    public static String ROT13(String texto)
    {
        //texto = texto.toUpperCase();
        String s = "";
        int ABC[] = new int[26];
        int abc[] = new int[26];

        for (int i = 65; i <= 90; i++)
        {
            ABC[i - 65] = i;
        }

        for (int i = 97; i <= 122; i++)
        {
            abc[i - 97] = i;
        }

        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) == ' ')
            {
                s += " ";
            } else
            {
                byte[] bytes = (texto.charAt(i) + "").getBytes(StandardCharsets.US_ASCII);
                if (bytes[0] >= 65 && bytes[0] <= 90)
                {
                    int n = Character.getNumericValue(texto.charAt(i)) + 55;
                    n = n - 65;
                    s += Character.toString((char) ABC[(n + 13) % 26]);
                } else
                {
                    int n = Character.getNumericValue(texto.charAt(i)) + 55;
                    n = n - 65;
                    s += Character.toString((char) abc[(n + 13) % 26]);
                }
            }
        }
        return s;
    }

    public static String Cesar(String texto, int des)
    {
        String s = "";
        texto = texto.toUpperCase();
        char abc[] =
        {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'X', 'Z'
        };

        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) == ' ' || texto.charAt(i) == ',' || texto.charAt(i) == '.')
            {
                s += texto.charAt(i);
            } else
            {
                System.out.println(buscar(texto.charAt(i), abc, des));
                s += abc[buscar(texto.charAt(i), abc, des)];
            }
        }
        return s;
    }

    public static int buscar(char c, char[] abc, int des)
    {
        int pos = -1;
        for (int i = 0; i < abc.length; i++)
        {
            if (c == abc[i])
            {
                return (i + des) % abc.length;
            }
        }
        return pos;
    }

    /*public static void main(String[] args)
    {
        String s = "B";
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        if (bytes[0] == 66)
        {
            System.out.println("ASCII Numeric Value: " + bytes[0]);
            System.out.println(Character.valueOf((char) bytes[0]));
        } else
        {
            System.out.println("pasalo a int");
        }

    }*/
}
