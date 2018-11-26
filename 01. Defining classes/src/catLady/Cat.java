package catLady;

public class Cat {
    private Siamese siamese;
    private Cymric cymric;
    private StreetExtraordinaire streetExtraordinaire;

    public void setSiamese(Siamese siamese) {
        this.siamese = siamese;
    }

    public void setCymric(Cymric cymric) {
        this.cymric = cymric;
    }

    public void setStreetExtraordinaire(StreetExtraordinaire streetExtraordinaire) {
        this.streetExtraordinaire = streetExtraordinaire;
    }

    public Siamese getSiamese() {
        return siamese;
    }

    public Cymric getCymric() {
        return cymric;
    }

    public StreetExtraordinaire getStreetExtraordinaire() {
        return streetExtraordinaire;
    }


}
