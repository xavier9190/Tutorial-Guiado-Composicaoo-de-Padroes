package techlearn.iterator;

// ITERATOR: contrato para percorrer qualquer coleção, sem saber como ela é por dentro.
public interface Iterator<T> {
    boolean hasNext(); // ainda tem item?
    T next();          // me dá o próximo
}
