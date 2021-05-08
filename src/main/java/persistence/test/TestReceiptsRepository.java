package persistence.test;

import model.Receipt;
import model.ReceiptsRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestReceiptsRepository implements ReceiptsRepository {

    private final List<Receipt> receipts = new ArrayList<>();

    @Override
    public List<Receipt> getAll() {
        return receipts;
    }

    @Override
    public void save(Receipt receipt) {
        receipts.add(receipt);
    }

    public boolean check(double liters, double mount, LocalDateTime date) {
        return receipts.contains(
                new Receipt(liters, mount, date)
        );
    }

}
