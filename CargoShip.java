import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CargoShip {

    private final int MAX_STAFF_AMOUNT = 3;
    private String name;
    private List<CrewMember> crewMembers = new ArrayList<CrewMember>();

    public CargoShip(String name) {
        this.name = name;
    }

    public void addCrewMember(CrewMember newMember) throws ExistingMemberException, FullCapacityException {
        if(crewMembers.size() >= MAX_STAFF_AMOUNT)
            throw new FullCapacityException("There's no more space on board!");
        for(CrewMember member : crewMembers) {
            if (member.getId() == newMember.getId())
                throw new ExistingMemberException("Member with this id: " + newMember.getId() + " is already on board!");
        }
        crewMembers.add(newMember);
    }

    public void removeCrewMember(String id) throws UnexistingMemberException {
        if(crewMembers.size() == 0)
            throw new UnexistingMemberException("The ship is empty!");
        for(CrewMember member : crewMembers) {
            if(member.getId() == id) {
                crewMembers.remove(member);
                return;
            }
        }
        throw new UnexistingMemberException("This member doesn't exist!");
    }

    public List<CrewMember> getCrewMembers() {
        return Collections.unmodifiableList(new ArrayList<CrewMember> (crewMembers));
    }

    public int getCapacity() {
        return this.MAX_STAFF_AMOUNT;
    }

    public int getAvailableSpaces() {
        return this.MAX_STAFF_AMOUNT - this.crewMembers.size();
    }

}
