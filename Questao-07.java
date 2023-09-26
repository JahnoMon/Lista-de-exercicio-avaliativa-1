/*
Escreva em Java classes referentes a peças de xadrez. Cada peça de xadrez
tem um valor referente a ela, quando são capturadas, assim como cada peça de xadrez
pode, no contexto, ocupar uma posição do tabuleiro (indicada por seu x e y). Escreva o
método possiveisMovimentos(), que, considerando a posição atual da peça, indica quais
são os possíveis movimentos dela. Esse método deve funcionar de forma diferente para
cada peça. Utilize dos princípios de orientação a objetos para fazer isso da melhor maneira.
*/

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
        for (int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++){
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7 && (i != x || j != y)) {
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
        System.out.println("Possiveis movimentos para o Peao na posicao (" + x + ", " + y + "):");
        System.out.println("");
        int[] movimentosX = {1, 1, 1};
        int[] movimentosY = {-1, 0, 1};

        for (int i = 0; i < 3; i++){
            int novoX = x + movimentosX[i];
            int novoY = y + movimentosY[i];

            if (novoX >= 0 && novoX <= 7 && novoY >= 0 && novoY <= 7) {
                System.out.print("P ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }
}


class Rainha extends PecaXadrez{
    public Rainha(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos(){
        System.out.println("Possiveis movimentos para o Rei na posicao (" + x + ", " + y + "):");
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

 class Torre extends PecaXadrez{
    public Torre(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos(){
        System.out.println("Possiveis movimentos para o Rei na posicao (" + x + ", " + y + "):");
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

class Bispo extends PecaXadrez{
    public Bispo(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos(){
        System.out.println("Possiveis movimentos para o Rei na posicao (" + x + ", " + y + "):");
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

class Cavalo extends PecaXadrez{
    public Cavalo(int x, int y){
        super(x, y, 10);
    }

    @Override
    public void possiveisMovimentos(){
        System.out.println("Possiveis movimentos para o Rei na posicao (" + x + ", " + y + "):");
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


class Main{
    public static void main(String[] args){
        Peao rei = new Peao(3, 3);
        rei.possiveisMovimentos();
    }
}


