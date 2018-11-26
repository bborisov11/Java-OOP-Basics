package militaryElite.classImpl;

import militaryElite.interfaces.Engineer;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class EngineerImpl extends BaseSpecialisedSoldier implements Engineer {

    private String corps;

    private HashSet<RepairImpl> repairImpls;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String currentCorps) {
        super(id, firstName, lastName, salary, currentCorps);

        this.corps = currentCorps;
        repairImpls = new LinkedHashSet<>();
    }

    public HashSet<RepairImpl> getRepairImpls() {
        return repairImpls;
    }


    @Override
    public String toString() {
                StringBuilder engineer = new StringBuilder();
                engineer.append(super.toString()).append(System.lineSeparator()).append("Repairs:");
                int i = 0;
                if(this.repairImpls.size() > 0) {
                    engineer.append(System.lineSeparator());
                }
                    for (RepairImpl repairImpl : repairImpls) {
                        engineer.append(repairImpl.toString()).append(i++ == this.repairImpls.size() - 1 ? "" : System.lineSeparator());
                    }

        return engineer.toString();
    }
}
