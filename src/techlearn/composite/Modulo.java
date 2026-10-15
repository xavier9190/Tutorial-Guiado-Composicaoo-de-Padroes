package techlearn.composite;

import techlearn.iterator.Iterator;
import techlearn.iterator.ModuloIterator;
import techlearn.logging.LoggerService;
import java.util.ArrayList;
import java.util.List;

// COMPOSITE (Composite): contém outros componentes (aulas ou outros módulos).
public class Modulo extends ComponenteCatalogo {
    private String nome;
    private List<ComponenteCatalogo> subComponentes = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionar(ComponenteCatalogo componente) {
        subComponentes.add(componente);
        // usa o Singleton
        LoggerService.getInstance().log("Item '" + componente.getNome()
                + "' adicionado ao módulo '" + this.nome + "'.");
    }

    @Override
    public void remover(ComponenteCatalogo componente) {
        subComponentes.remove(componente);
        LoggerService.getInstance().log("Item '" + componente.getNome()
                + "' removido do módulo '" + this.nome + "'.");
    }

    @Override
    public String getNome() { return nome; }

    // Soma a duração dos filhos (cada filho pode ser aula OU outro módulo).
    @Override
    public int getDuracaoMinutos() {
        int total = 0;
        for (ComponenteCatalogo c : subComponentes) {
            total += c.getDuracaoMinutos();
        }
        return total;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n[Módulo/Curso]: " + getNome()
                + " | Duração Total: " + getDuracaoMinutos() + " min");
        System.out.println("--------------------------------------------------");
        for (ComponenteCatalogo c : subComponentes) {
            c.exibirDetalhes();
        }
    }

    // Entrega um Iterator em vez de expor a lista.
    @Override
    public Iterator<ComponenteCatalogo> criarIterator() {
        return new ModuloIterator(subComponentes);
    }
}
