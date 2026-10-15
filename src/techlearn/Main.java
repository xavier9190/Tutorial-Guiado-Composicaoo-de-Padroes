package techlearn;

import techlearn.composite.*;
import techlearn.iterator.ArvoreIterator;
import techlearn.iterator.Iterator;
import techlearn.logging.LoggerService;

public class Main {
    public static void main(String[] args) {
        LoggerService logger = LoggerService.getInstance();
        logger.log("Iniciando montagem da estrutura de cursos...");

        // Monta a árvore: Curso -> Módulos -> Aulas
        Modulo cursoEngenharia = new Modulo("Engenharia de Software Moderna");

        Modulo moduloOO = new Modulo("Módulo 1: Orientação a Objetos Avançada");
        moduloOO.adicionar(new Aula("Aula 1.1: Coesão e Acoplamento", 45));
        moduloOO.adicionar(new Aula("Aula 1.2: Interfaces e Polimorfismo", 60));

        Modulo moduloPadroes = new Modulo("Módulo 2: Padrões de Projeto (GoF)");
        moduloPadroes.adicionar(new Aula("Aula 2.1: Singleton na Prática", 30));
        moduloPadroes.adicionar(new Aula("Aula 2.2: Composite Hierárquico", 50));
        moduloPadroes.adicionar(new Aula("Aula 2.3: Iterator para Coleções", 40));

        cursoEngenharia.adicionar(moduloOO);
        cursoEngenharia.adicionar(moduloPadroes);

        logger.log("Estrutura montada com sucesso. Exibindo detalhes da ementa:");
        cursoEngenharia.exibirDetalhes(); // Composite em ação

        System.out.println("\n==================================================");
        System.out.println(" Varredura do Curso Principal via Iterator:");
        System.out.println("==================================================");

        Iterator<ComponenteCatalogo> iterator = cursoEngenharia.criarIterator();
        while (iterator.hasNext()) {
            ComponenteCatalogo subItem = iterator.next();
            logger.log("Navegando no Item Raiz: " + subItem.getNome()
                    + " | Duração acumulada: " + subItem.getDuracaoMinutos() + " min");
        }

        // ===== PASSO 5: aulas com duração <= 45 min em TODO o curso =====
        System.out.println("\n==================================================");
        System.out.println(" Aulas curtas (<= 45 min) do curso inteiro:");
        System.out.println("==================================================");

        Iterator<ComponenteCatalogo> todos = new ArvoreIterator(cursoEngenharia.criarIterator());
        while (todos.hasNext()) {
            ComponenteCatalogo item = todos.next();
            if (item instanceof Aula && item.getDuracaoMinutos() <= 45) {
                logger.log("Aula curta: " + item.getNome() + " (" + item.getDuracaoMinutos() + " min)");
            }
        }

        logger.log("Execução da atividade finalizada.");
    }
}
