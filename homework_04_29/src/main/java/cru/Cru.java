package cru;

public enum Cru {
    AUTRE(80),
    PREMIER(90),
    GRAND(100);

    private int quality;

    Cru(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }
}
