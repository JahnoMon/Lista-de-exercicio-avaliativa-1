/*
Escreva uma classe referente a Data, que contém dia, mês e ano. As datas
podem ser criadas de duas maneiras: recebendo o dia, mês e ano correspondentes a ela ou
nenhum valor, caso esse em que se entende que o dia, mês e ano dessa data é o dia, mês
e ano atuais. Implemente alguns métodos nessa classe, listados abaixo:

a) diaDaSemana(): retorna uma String que diz qual é o dia da semana da Data
b) diasDeDiferenca(Data outra), retorna um inteiro indicando o número de dias de diferença entre o objeto data a partir do qual o método foi chamado e uma outra data 
passada como argumento.
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Calendar calendario = Calendar.getInstance();
        this.dia = calendario.get(Calendar.DAY_OF_MONTH);
        this.mes = calendario.get(Calendar.MONTH) + 1;
        this.ano = calendario.get(Calendar.YEAR);
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String diaDaSemana() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Calendar calendario = Calendar.getInstance();
        calendario.set(this.ano, this.mes - 1, this.dia);
        Date data = calendario.getTime();
        return sdf.format(data);
    }

    public int diasDeDiferenca(Data outra) {
        Calendar calendario1 = Calendar.getInstance();
        calendario1.set(this.ano, this.mes - 1, this.dia);

        Calendar calendario2 = Calendar.getInstance();
        calendario2.set(outra.ano, outra.mes - 1, outra.dia); /]

        long diferencaMillis = calendario1.getTimeInMillis() - calendario2.getTimeInMillis();
        return (int) (diferencaMillis / (24 * 60 * 60 * 1000));
    }

    public static void main(String[] args) {
        Data dataAtual = new Data();
        System.out.println("Data Atual: " + dataAtual.diaDaSemana());

        Data outraData = new Data(10, 9, 2023);
        int diferencaDias = dataAtual.diasDeDiferenca(outraData);
        System.out.println("Diferença de dias entre a data atual e outra data: " + diferencaDias + " dias");
    }
}
