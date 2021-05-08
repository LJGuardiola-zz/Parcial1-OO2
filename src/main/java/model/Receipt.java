package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Receipt {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final double mount;
    private final double liters;
    private final LocalDateTime date;

    public Receipt(double liters, double mount) {
        this(liters, mount, LocalDateTime.now());
    }

    public Receipt(double liters, double mount, LocalDateTime date) {
        this.liters = liters;
        this.mount = mount;
        this.date = date;
    }

    public double getLiters() {
        return liters;
    }

    public double getMount() {
        return mount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getFormattedDate() {
        return date.format(DATE_FORMATTER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Double.compare(receipt.mount, mount) == 0 &&
               Double.compare(receipt.liters, liters) == 0 &&
               date.equals(receipt.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mount, liters, date);
    }

}
