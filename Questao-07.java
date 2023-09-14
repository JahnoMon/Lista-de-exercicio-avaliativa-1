/*
Escreva em Java classes referentes a peças de xadrez. Cada peça de xadrez
tem um valor referente a ela, quando são capturadas, assim como cada peça de xadrez
pode, no contexto, ocupar uma posição do tabuleiro (indicada por seu x e y). Escreva o
método possiveisMovimentos(), que, considerando a posição atual da peça, indica quais
são os possíveis movimentos dela. Esse método deve funcionar de forma diferente para
cada peça. Utilize dos princípios de orientação a objetos para fazer isso da melhor maneira.
*/

class PecaXadrez{
    private int x;
    private int y;
    private int valor;
    private boolean capturada;

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
        System.out.println("Possiveis movimentos para o Rei na posicao (" + x + ", " + y + "):");
        //System.out.println("");
        for (int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++){
                if (i >= 0 && i <= 7 && j >= 0 && j <= 7 && !(i == x && j == y)) {
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
        Rei rei = new Rei(3, 3);
        rei.possiveisMovimentos();
    }
}
