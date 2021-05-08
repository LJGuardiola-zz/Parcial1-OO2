import model.FuelStation;
import model.Fuels;
import model.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.test.TestReceiptsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FuelStationTest {

    private TestReceiptsRepository repository;
    private FuelStation station;

    @BeforeEach
    void setUp() {
        repository = new TestReceiptsRepository();
        station = new FuelStation(repository);
    }

    @Test
    void get_super_fuel_final_cost_() {
        double cost = station.getFinalCost(Fuels.SUPER, 10);
        assertEquals(
                Fuels.SUPER.getCost(10), cost
        );
    }

    @Test
    void get_normal_fuel_final_cost_() {
        double cost = station.getFinalCost(Fuels.COMUN, 10);
        assertEquals(
                Fuels.COMUN.getCost(10), cost
        );
    }

    @Test
    void pay_fuel() {
        station.pay(Fuels.COMUN, 10);
        assertTrue(
                repository.check(
                        10, Fuels.COMUN.getCost(10), LocalDateTime.now()
                )
        );
    }

    @Test
    void get_receipts() {

        station.pay(Fuels.COMUN, 10);
        station.pay(Fuels.SUPER, 12);

        List<Receipt> expected = new ArrayList<>();

        expected.add(new Receipt(10, Fuels.COMUN.getCost(10)));
        expected.add(new Receipt(12, Fuels.SUPER.getCost(12)));

        List<Receipt> receipts = station.getReceipts(LocalDate.now(), LocalDate.now());

        assertEquals(expected, receipts);

    }

}
