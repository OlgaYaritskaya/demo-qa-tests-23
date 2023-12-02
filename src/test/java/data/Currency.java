package data;

public enum Currency {
    RUB, BYN, USD, KZT, UZS, KGS, AMD;

    public final String description;

    Currency(String description) {
        this.description = description;
    }
}
