package militaryElite.interfaces;

import militaryElite.classImpl.PrivateImpl;

import java.util.HashSet;

public interface LeutenantGeneral extends Soldier {
     HashSet<PrivateImpl> getPrivateImpls();
}
