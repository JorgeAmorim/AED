package series.serie2.problema;

import java.io.*;
public class Replace
{
    static Map newMap = new Map();
    static String frase;

    public static void main(String[] args) throws IOException {
        readDesktop(args[1]);
        readDictionary(args[0]);
        readReplace(args[2]);
    }

    public static void readDictionary(String file) throws IOException {
        BufferedReader dict = new BufferedReader(new FileReader(file));
        String nsq;
        while((nsq = dict.readLine()) != null)
        {
            String[] f = nsq.split(" ");
            newMap.put(f[0],f[1]);
        }
    }

    public static void readDesktop(String file) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        frase = bf.readLine();
    }

    public static void readReplace(String file) throws FileNotFoundException {
        String[] frases = frase.split(" ");
        String aux = "";
        for (int i = 0; i< frases.length; ++i)
        {
            String x = (String)newMap.get(frases[i]);
            if(x==null)
                aux+=frases[i] + " ";
            else
                aux+=x + " ";
        }
        PrintWriter pw = new PrintWriter(file);
        pw.write(aux);
        pw.close();
    }
}