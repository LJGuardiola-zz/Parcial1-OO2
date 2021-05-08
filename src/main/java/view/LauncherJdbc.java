package view;

import model.ReceiptsRepository;
import persistence.jdbc.JdbcReceiptsRepository;

public class LauncherJdbc extends Launcher {

    private final ReceiptsRepository repository = new JdbcReceiptsRepository();

    @Override
    public ReceiptsRepository getRepository() {
        return repository;
    }

}
