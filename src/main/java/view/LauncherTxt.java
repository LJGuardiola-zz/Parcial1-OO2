package view;

import model.ReceiptsRepository;
import persistence.file.FileReceiptsRepository;

public class LauncherTxt extends Launcher {

    private final ReceiptsRepository repository = new FileReceiptsRepository("sales.txt");

    @Override
    public ReceiptsRepository getRepository() {
        return repository;
    }

}
