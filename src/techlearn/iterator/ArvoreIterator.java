package techlearn.iterator;

import techlearn.composite.ComponenteCatalogo;
import java.util.Stack;

// Percorre a ÁRVORE INTEIRA (módulos, submódulos e aulas), descendo nos níveis.
// Truque: uma pilha de iteradores. O do topo é o nível em que estamos.
public class ArvoreIterator implements Iterator<ComponenteCatalogo> {
    private Stack<Iterator<ComponenteCatalogo>> pilha = new Stack<>();

    public ArvoreIterator(Iterator<ComponenteCatalogo> raiz) {
        pilha.push(raiz);
    }

    @Override
    public boolean hasNext() {
        while (!pilha.isEmpty()) {
            if (pilha.peek().hasNext()) {
                return true;   // ainda tem item neste nível
            }
            pilha.pop();       // nível acabou: volta pro nível de cima
        }
        return false;          // pilha vazia: acabou tudo
    }

    @Override
    public ComponenteCatalogo next() {
        if (!hasNext()) return null;
        ComponenteCatalogo atual = pilha.peek().next();
        // Empilha os filhos do item atual. Se for Aula, entra um NullIterator
        // (vazio) que sai da pilha sozinho no próximo hasNext().
        pilha.push(atual.criarIterator());
        return atual;
    }
}
