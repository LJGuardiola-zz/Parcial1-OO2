package view;

import model.ReceiptsRepository;
import persistence.file.FileReceiptsRepository;

public class LauncherFile extends Launcher {

    private final ReceiptsRepository repository = new FileReceiptsRepository("receipts.txt");

    @Override
    public ReceiptsRepository getRepository() {
        return repository;
    }

}
