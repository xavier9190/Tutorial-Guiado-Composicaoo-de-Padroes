package techlearn.composite;

import techlearn.iterator.Iterator;

// COMPOSITE (Component): tudo no catálogo (Aula, Módulo, Curso) é um ComponenteCatalogo.
// Assim o cliente trata todos do mesmo jeito.
public abstract class ComponenteCatalogo {

    // Por padrão, "não pode". Só o Módulo sobrescreve estes dois.
    public void adicionar(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operação não suportada neste nível.");
    }

    public void remover(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operação não suportada neste nível.");
    }

    public String getNome() {
        throw new UnsupportedOperationException();
    }

    public int getDuracaoMinutos() {
        throw new UnsupportedOperationException();
    }

    public abstract void exibirDetalhes();

    public abstract Iterator<ComponenteCatalogo> criarIterator();
}
