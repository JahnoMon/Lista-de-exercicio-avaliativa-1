/*
Desenvolva em Java uma classe que representa o arcabouço lógico do
jogo-da-velha. Nele, as seguintes funcionalidades devem existir:

a) jogar(int x, int y, Simbolo s): joga s na posição x, y do tabuleiro.
b) checar(): verifica o estado de jogo, retornando se 1 se o jogador de ‘O’ venceu, -1 seo jogador de ‘X’ venceu e 0 se ninguém venceu.
c) limpar(): reseta o tabuleiro.
*/

public class JogoDaVelha{
    private char[][] tabuleiro;
    private char jogador1;

    public JogoDaVelha(){
        tabuleiro = new char[3][3];
        jogador1 = 'X';
        limpar();
    }

    // 
    public void jogar(int x, int y){
        if (x < 0 || x > 2 || y < 0 || y > 2 || tabuleiro[x][y] != ' ') {
            System.out.println("Jogada invalida. Tente novamente.");
            return;
        }

        tabuleiro[x][y] = jogador1;
        // alterna para o proximo jogador
        jogador1 = (jogador1 == 'X') ? 'O' : 'X';
    }

    // b)
    public int checar(){
        // verifica se algum jogador venceu
        for (int i = 0; i < 3; i++) {
            // verifica linhas e colunas
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ')
                return (tabuleiro[i][0] == 'X') ? -1 : 1;
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i] && tabuleiro[0][i] != ' ')
                return (tabuleiro[0][i] == 'X') ? -1 : 1;
        }
        // verifica diagonais
        if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ')
                || (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' '))
            return (tabuleiro[1][1] == 'X') ? -1 : 1;

        // verifica se hjouve empate
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ')
                    return 0; // caso o jogo ainda nao tenha acabado
            }
        }

        return 2; // o que resta em caso de empate
    }

    // c)
    public void limpar(){
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        jogador1 = 'X';
    }
}
