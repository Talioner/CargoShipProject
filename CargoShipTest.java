import org.junit.Before;

import static org.junit.Assert.*;

public class CargoShipTest {

    private CargoShip ship;
    private CrewMember member1;
    private CrewMember member2;
    private CrewMember member3;
    private CrewMember member4;



    @Before
    public void setup() {
        ship = new CargoShip("Stateczek");
        member1 = new Officer("Officer1", "John", 28);
        member2 = new Seamen("Seaman1", "Steve", 66);
        member3 = new Officer("Officer2", "Mlody", 17);
        member4 = new Seamen("Seaman2", "Seba", 22);
    }

    @org.junit.Test
    public void addCrewMember() {
        ship.addCrewMember(member1);
        assertEquals("The member was not added",1, ship.getCrewMembers().size() );
        ship.addCrewMember(member2);
        ship.addCrewMember(member3);
        assertEquals("The members were not added",3, ship.getCrewMembers().size() );
    }

    @org.junit.Test(expected = ExistingMemberException.class)
    public void addExistingCrewMember() {
        ship.addCrewMember(member3);
        ship.addCrewMember(member3);
    }

    @org.junit.Test(expected = FullCapacityException.class)
    public void exceedCapacity() {
        ship.addCrewMember(member1);
        ship.addCrewMember(member2);
        ship.addCrewMember(member3);
        ship.addCrewMember(member4);
    }

    @org.junit.Test
    public void removeCrewMember() {
        ship.addCrewMember(member1);
        ship.addCrewMember(member2);
        assertEquals("The members was not removed", 2, ship.getCrewMembers().size());
        ship.removeCrewMember("Seaman1");
        //assertEquals("The members was not removed", false, ship.getCrewMembers().contains(member2));
    }

    public void removeUnexistingCrewMember() {
        ship.addCrewMember(member1);
        ship.addCrewMember(member2);
        ship.removeCrewMember("Seaman2");
    }

    @org.junit.Test
    public void getAvailableSpaces() {
        ship.addCrewMember(member1);
        ship.addCrewMember(member2);
        assertEquals("Available spaces counted wrong", 1, ship.getAvailableSpaces());
    }
}