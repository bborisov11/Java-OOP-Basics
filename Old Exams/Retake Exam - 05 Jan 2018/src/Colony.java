import Colonists.Colonist;

import java.util.*;
import java.util.stream.Collectors;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new HashMap<>();

    }

  //  public int getMaxFamilyCount() {
  //      return maxFamilyCount;
  //  }
//
  //  public int getMaxFamilyCapacity() {
  //      return maxFamilyCapacity;
  //  }
//
  //  public Map<String, Family> getFamilies() {
  //      return families;
  //  }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if(!this.families.containsKey(familyId)) {
            throw new IllegalArgumentException("family does not exist");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(familyId).append(":");//.append(System.lineSeparator());
        System.out.println(builder.toString());
        return families.get(familyId).getColonists().entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public void addColonist(Colonist colonist) {



       // if(!this.families.containsKey(colonist.getFamilyId())) {
            if (this.families.size() == this.maxFamilyCount) {
                throw new IllegalArgumentException("family is full");
            } else {
                this.families.putIfAbsent(colonist.getFamilyId(), new Family(colonist.getFamilyId()));
            }
       // }
        if(!this.families.get(colonist.getFamilyId()).getColonists().containsKey(colonist.getId())) {
            if (this.families.get(colonist.getFamilyId()).getColonists().size() == this.maxFamilyCapacity) {
                throw new IllegalArgumentException("colony is full");
            } else {
                this.families.get(colonist.getFamilyId()).getColonists().putIfAbsent(colonist.getId(), colonist);
            }
        }
    }

    public void removeColonist(String familyId, String memberId) {
            this.families.get(familyId).getColonists().remove(memberId);
            if(this.families.get(familyId).getColonists().size() == 0) {
                this.families.remove(familyId);
            }
    }

    public void removeFamily(String id) {
        this.families.remove(id);
    }

    public void grow(int years) {
            this.families.values().forEach(
                    x -> x.getColonists().values().forEach(y -> y.setAge(y.getAge() + years)));
    }

    public int getPotential() {

        return this.families.values().stream()
                .mapToInt(x -> x.getColonists().values().stream().mapToInt(Colonist::getPotential).sum()).sum();
    }

    public String getCapacity() {
        StringBuilder builder = new StringBuilder();
        builder.append("families: ").append(this.families.size()).append("/")
                .append(this.maxFamilyCount).append(System.lineSeparator());
            this.families.values().stream().sorted(Comparator.comparing(Family::getId))
                    .forEach(x -> builder.append("-").append(x.getId()).append(": ")
                    .append(x.getColonists().size()).append("/").append(this.maxFamilyCapacity)
                    .append(System.lineSeparator()));
            return builder.toString();
    }

}
