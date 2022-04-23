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
        char ABC[] =
        {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'X', 'Z'
        };

        char abc[] =
        {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'y', 'x', 'z'
        };

        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) == ' ' || texto.charAt(i) == ',' || texto.charAt(i) == '.')
            {
                s += texto.charAt(i);
            } else
            {
                if(texto.charAt(i) == 'Ñ')
                {
                    s += ABC[buscar(texto.charAt(i), ABC, des)];
                }else{
                    if (texto.charAt(i) == 'ñ')
                    {
                        s += abc[buscar(texto.charAt(i), abc, des)];
                    }else{
                        byte[] bytes = (texto.charAt(i) + "").getBytes(StandardCharsets.US_ASCII);

                        if ((bytes[0] >= 65 && bytes[0] <= 90))
                        {
                            s += ABC[buscar(texto.charAt(i), ABC, des)];
                        }

                        if ((bytes[0] >= 97 && bytes[0] <= 122))
                        {
                            s += abc[buscar(texto.charAt(i), abc, des)];
                        }
                    }
                }
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
                return abs((i + des) % abc.length);
            }
        }
        return pos;
    }

    public static int abs(int n)
    {
        return n > 0 ? n : -n;
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
