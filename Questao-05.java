/*
Escreva um programa em Java que manipule parágrafos de texto em inglês
(não precisa ser manipulação de arquivos) e substitua todas as ocorrências de “I” por “we”.
Caso o “we” seja a primeira palavra após a vírgula, a substituição deve ser por “We”. Dica
importante: tome cuidado com o uso de “==”.
*/

public class editorDeParagrafo {
    public static void main(String[] args) {
        String paragrafo = "I say. You are alone, child. There is only darkness for you, and only death for your people. These ancients are just the beginning. I will command a great and terrible army, and we will sail to a billion worlds. We will sail until every light has been extinguished. You are strong, child, but I am beyond strength. I am the end, and I have come for you, Finn.";

        String[] sentenca = paragrafo.split("\\.\\s*");

        StringBuilder resultado = new StringBuilder();

        for (String sentenca : sentencas) {
            String[] palavras = sentenca.split("\\s+");
            StringBuilder sentencaModificada = new StringBuilder();

            boolean proximaMaiuscula = false;

            for (String palavra : palavras) {
                if (palavra.equals("I")) {
                    palavra = "we";
                } else if (palavra.equals("we") && proximaMaiuscula) {
                    palavra = "We";
                    proximaMaiuscula = false;
                }

                if (palavra.endsWith(",")) {
                    proximaMaiuscula = true;
                }

                sentencaModificada.append(palavra).append(" ");
            }

            result.append(modifiedSentence.toString().trim()).append(". ");

        }
    }
}
