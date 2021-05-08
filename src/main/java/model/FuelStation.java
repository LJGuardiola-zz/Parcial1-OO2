package model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FuelStation {

    private final ReceiptsRepository repository;

    public FuelStation(ReceiptsRepository repository) {
        this.repository = repository;
    }

    public double getFinalCost(Fuel fuel, Integer liters) {
        return new Sale(fuel, liters).getFinalCost();
    }

    public void pay(Fuel fuel, Integer liters) {
        repository.save(
                new Sale(fuel, liters).pay()
        );
    }

    public List<Receipt> getReceipts(LocalDate start, LocalDate end) {
        if (start == null || end == null){
            throw new RuntimeException("Ingresa las fechas \"Desde\" y \"Hasta\"");
        }
        if (start.isAfter(end)){
            throw new RuntimeException("La fecha \"Desde\" debe ser menor a la fecha \"Hasta\"");
        }
        return repository.getAll().stream().filter(
                receipt -> isBetween(receipt.getDate().toLocalDate(), start, end)
        ).collect(Collectors.toList());
    }

    private boolean isBetween(LocalDate date, LocalDate start, LocalDate end) {
        return (date.equals(start) || date.isAfter(start)) && (date.equals(end) || date.isBefore(end));
    }

}
