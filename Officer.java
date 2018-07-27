public class Officer extends CrewMember {

    private String rank;

    public Officer(String id, String name, int age) {
        super(id, name, age);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
