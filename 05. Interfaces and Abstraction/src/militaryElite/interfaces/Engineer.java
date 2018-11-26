package militaryElite.interfaces;

import militaryElite.classImpl.RepairImpl;

import java.util.HashSet;

public interface Engineer extends Soldier {
    HashSet<RepairImpl> getRepairImpls();
}
