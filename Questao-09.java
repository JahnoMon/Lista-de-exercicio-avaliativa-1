/*
Crie a classe Stack, que represente uma pilha que armazena strings.
Implemente métodos de adição e remoção de elementos, verificação de se a pilha está
vazia e construtores.
*/

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack{
    private Lista<String> elementos;

    public Stack(){
        elementos = new ArrayList<>();
    }

    public Stack(List<String> elementosIniciais){
        elementos = new ArrayList<>(elementosIniciais);
    }

    public void push(String elemento){
        elementos.add(elemento);
    }

    public String pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        int indiceTopo = elementos.size() - 1;
        String topo = elementos.remove(indiceTopo);
        return topo;
    }

    public String peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        int indiceTopo = elementos.size() - 1;
        return elementos.get(indiceTopo);
    }

    public boolean isEmpty(){
        return elementos.isEmpty();
    }

    public int size(){
        return elementos.size();
    }

    public void clear(){
        elementos.clear();
    }
}
