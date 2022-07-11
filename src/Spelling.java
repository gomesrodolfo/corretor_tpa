
import corretor.Arquivo;
import corretor.Hash;
import corretor.Palavra;
import java.io.*;
import java.util.*;
import java.util.regex.*;

class Spelling {

    private final SortedSet<String> nWords = new TreeSet<String>();
    private final char[] alfabeto = {'a', 'á', 'ä', 'à', 'ã', 'â', 'b', 'c', 'ç', 'd', 'e', 'é', 'ë', 'è', 'ê', 'f', 'g', 'h', 'i', 'í', 'ï', 'ì', 'î', 'j', 'k', 'l', 'm', 'n', 'o', 'ó', 'ö', 'ò', 'õ', 'ô', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'ü', 'ù', 'û', 'v', 'x', 'y', 'z'};

    public Spelling(String word) throws IOException {

        String conteudo = "";
        Hash hash = new Hash(20971520);

        try {
//            FileReader arq = new FileReader(caminho);
//            BufferedReader lerArq = new BufferedReader(arq);
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream("dict/pt1.txt"), "UTF-8"));
            String linha = "";
            for (String temp = ""; temp != null; temp = lerArq.readLine()) {
                nWords.add(temp);
            }

            try {
                linha = lerArq.readLine();
                int i = 0;

                while (linha != null) {
                    Palavra palavra = new Palavra(i, linha);
                    hash.inserir(palavra);
                    conteudo = conteudo + linha;
                    linha = lerArq.readLine();
                    System.out.println("Palavra: " + linha);
                    i = i + 1;
                    System.out.println(nWords);
                }

                lerArq.close();

            } catch (IOException e) {
                conteudo = "Erro: Nao foi possivel ler o arquivo!";
            }
        } catch (FileNotFoundException e) {
            conteudo = "Erro: Arquivo nao encontrado!";
        }

//            Palavra lstPalavras;
//            String s_caminho = "dict/pt2.txt";
//            Arquivo arq = new Arquivo();
//            arq.Read(s_caminho);
//            int index = 0;
////            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//           while(index < arq)
//
//            for (String temp = ""; temp != null; temp = in.readLine()) {
//                nWords.add(temp);
//            }
////            in.close();
    }

    private ArrayList<String> edits(String word) {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < word.length(); ++i) {
            result.add(word.substring(0, i) + word.substring(i + 1));
        }

        for (int i = 0; i < word.length() - 1; ++i) {
            result.add(word.substring(0, i) + word.substring(i + 1, i + 2) + word.substring(i, i + 1) + word.substring(i + 2));
        }

        for (int i = 0; i < word.length(); ++i) {
            for (int z = 0; z < alfabeto.length; z++) {
                char c = alfabeto[z];
                result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i + 1));
            }
        }

        for (int i = 0; i <= word.length(); ++i) {
            for (int z = 0; z < alfabeto.length; z++) {
                char c = alfabeto[z];
                result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
            }
        }
        return result;
    }

    public final String[] correct(String word) {
        if (nWords.contains(word)) {
            return null;
        }

        ArrayList<String> list = edits(word);
        SortedSet<String> candidates = new TreeSet<String>();

        for (String s : list) {
            if (nWords.contains(s)) {
                candidates.add(s);
            }
        }

        if (candidates.size() > 0) {
            return candidates.toArray(new String[0]);
        }

        for (String s : list) {
            for (String w : edits(s)) {
                if (nWords.contains(w)) {
                    candidates.add(w);
                }
            }
        }
        return candidates.size() > 0 ? candidates.toArray(new String[0]) : null;
    }
}
