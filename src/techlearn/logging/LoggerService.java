package techlearn.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// SINGLETON: só existe UM logger no sistema inteiro.
public class LoggerService {

    // Criada uma única vez, quando a classe é carregada (já é thread-safe).
    private static final LoggerService INSTANCE = new LoggerService();

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Construtor privado: ninguém de fora consegue fazer "new LoggerService()".
    private LoggerService() {
        System.out.println("[SISTEMA] Serviço de Logging Inicializado.");
    }

    // Único jeito de pegar o logger.
    public static LoggerService getInstance() {
        return INSTANCE;
    }

    public void log(String mensagem) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] [LOG]: " + mensagem);
    }
}
