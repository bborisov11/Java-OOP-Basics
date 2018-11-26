package militaryElite.classImpl;

import militaryElite.interfaces.LeutenantGeneral;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class LeutenantGeneraImpl extends PrivateImpl implements LeutenantGeneral {
    private HashSet<PrivateImpl> privateImpls;

    public LeutenantGeneraImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        privateImpls = new LinkedHashSet<>();
    }

    @Override
    public HashSet<PrivateImpl> getPrivateImpls() {
        return privateImpls;
    }


    @Override
    public String toString() {
        StringBuilder leutenant = new StringBuilder();
            leutenant.append(super.toString()).append(System.lineSeparator()).append("Privates:").append(this.privateImpls.size() != 0 ? '\n' : "");
            for (PrivateImpl aPrivateImpl : this.privateImpls.stream()
                    .sorted(Comparator.comparing(BaseSoldier::getId,Comparator.reverseOrder())).collect(Collectors.toList())) {
                leutenant.append("  ").append(aPrivateImpl.toString()).append(System.lineSeparator());
            }

        return leutenant.toString();
    }
}
