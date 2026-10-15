package techlearn.iterator;

// Iterador "vazio": usado pela Aula, que não tem filhos.
public class NullIterator<T> implements Iterator<T> {
    @Override
    public boolean hasNext() { return false; }

    @Override
    public T next() { return null; }
}
