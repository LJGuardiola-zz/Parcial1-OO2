package persistence.file;

import model.Receipt;
import model.ReceiptsRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FileReceiptsRepository implements ReceiptsRepository {

    private final File file;

    public FileReceiptsRepository(String file) {
        this.file = new File(file);
    }

    @Override
    public List<Receipt> getAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                    .map(line -> line.split(", "))
                    .map(str -> new Receipt(
                            Double.parseDouble(str[0]),
                            Double.parseDouble(str[1]),
                            LocalDateTime.parse(
                                    str[2], Receipt.DATE_FORMATTER
                            )
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo de ventas.", e);
        }
    }

    @Override
    public void save(Receipt receipt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(
                    receipt.getLiters() + ", " + receipt.getMount() + ", " + receipt.getFormattedDate() + "\n"
            );
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir en el archivo de ventas.", e);
        }
    }

}
