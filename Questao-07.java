/*
Escreva em Java classes referentes a peças de xadrez. Cada peça de xadrez
tem um valor referente a ela, quando são capturadas, assim como cada peça de xadrez
pode, no contexto, ocupar uma posição do tabuleiro (indicada por seu x e y). Escreva o
método possiveisMovimentos(), que, considerando a posição atual da peça, indica quais
são os possíveis movimentos dela. Esse método deve funcionar de forma diferente para
cada peça. Utilize dos princípios de orientação a objetos para fazer isso da melhor maneira.
*/

package Questoes;

public class Questao_7 {
	public static void main(String[] args){
        Rei rei = new Rei(3, 3);
        rei.possiveisMovimentos();
        System.out.print("");
        
        Peao peao = new Peao(8, 8);
        peao.possiveisMovimentos();
        System.out.print("");
        
        Rainha rainha = new Rainha(3, 3);
        rainha.possiveisMovimentos();
        System.out.print("");

        Torre torre = new Torre(3, 3);
        torre.possiveisMovimentos();
        System.out.print("");

        Bispo bispo = new Bispo(3, 3);
        bispo.possiveisMovimentos();
        System.out.print("");

        Cavalo cavalo = new Cavalo(3, 3);
        cavalo.possiveisMovimentos();
        System.out.print("");
}
}

class PecaXadrez{
    protected int x;
    protected int y;
    protected int valor;
    protected boolean capturada;

    public PecaXadrez(int x, int y, int valor){
        this.x = x;
        this.y = y;
        this.valor = valor;
        this.capturada = false;
    }

    public void mover(int novoX, int novoY){
        this.x = novoX;
        this.y = novoY;
    }

    public void capturar(){
        this.capturada = true;
    }

    public boolean estaCapturada(){
        return capturada;
    }

    public int getValor(){
        return valor;
    }

    public void possiveisMovimentos(){
        System.out.println("Implementacao padrao: Peca nao pode se mover.");
    }
}

class Rei extends PecaXadrez{
    public Rei(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos(){
        System.out.println("Possiveis movimentos para o Rei na posiaoo (" + x + ", " + y + "):");
        System.out.println("");
        for (int i = 0; i <= 7; i++){
            for (int j = 0; j <= 7; j++){
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7 && (i != x || j != y) && (i == x - 1 && j == y - 1) || ((i == x - 1 && j == y - 1)) ) {
                    System.out.print("P ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}

 class Peao extends PecaXadrez{
    public Peao(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos(){
        System.out.println("Possiveis movimentos para o Peao na posiaoo (" + x + ", " + y + "):");
        System.out.println("");
        for (int i = 0; i <= 7; i++){
            for (int j = 0; j <= 7; j++){
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7 && (i == x - 2 && j == y - 1)) {
                    System.out.print("P ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}

class Rainha extends PecaXadrez {
    public Rainha(int x, int y) {
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos() {
        System.out.println("Possiveis movimentos para a Rainha na posicao (" + x + ", " + y + "):");
        System.out.println("");
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (i != x || j != y) {
                    // so assim p diagonal inversa:
                    if (i == x || j == y || Math.abs(i - x) == Math.abs(j - y)) { 
                        System.out.print("P ");
                    } else {
                        System.out.print("- ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}

 class Torre extends PecaXadrez{
    public Torre(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos() {
        System.out.println("Possiveis movimentos para a Torre na posicao (" + x + ", " + y + "):");
        System.out.println("");
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (i != x || j != y) {
                    // so assim p diagonal inversa:
                    if (i == x || j == y) { 
                        System.out.print("P ");
                    } else {
                        System.out.print("- ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.printf("%n%n");
    }
}

class Bispo extends PecaXadrez{
    public Bispo(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos() {
        System.out.println("Possiveis movimentos para a Rainha na posicao (" + x + ", " + y + "):");
        System.out.println("");
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (i != x || j != y) {
                    // so assim p diagonal inversa:
                    if ( Math.abs(i - x) == Math.abs(j - y)) { 
                        System.out.print("P ");
                    } else {
                        System.out.print("- ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}

class Cavalo extends PecaXadrez{
    public Cavalo(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos(){
        System.out.println("Possiveis movimentos para o Cavalo na posicao (" + x + ", " + y + "):");
        System.out.println("");
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7 && (i == 0 && j <= 2) && x != 0 && y != 0) {
                System.out.print("P ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
