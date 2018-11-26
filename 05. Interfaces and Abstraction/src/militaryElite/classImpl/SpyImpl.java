package militaryElite.classImpl;

public class SpyImpl extends BaseSoldier {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder spy = new StringBuilder();
        spy.append(super.toString()).append(System.lineSeparator()).append("Code Number: ").append(this.codeNumber);
        return spy.toString();
    }
}
