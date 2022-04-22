package clases;

/**
 *
 * @author Kevin
 */
public class Metodos
{

    public static String ROT13(String texto)
    {
        texto = texto.toUpperCase();
        String s = "";

        int abc[] = new int[26];

        for (int i = 65; i <= 90; i++)
        {
            abc[i - 65] = i;
        }

        for (int i = 0; i < texto.length(); i++)
        {
            int n = Character.getNumericValue(texto.charAt(i)) + 55;
            n = n - 65;
            s += Character.toString((char) abc[ (n+13) % 26 ]);
        }

        return s;
    }

    public static void main(String[] args)
    {
        System.out.println(ROT13("Algoritmo"));
    }
}
