public class Seamen  extends CrewMember {

    private String jobDescription;

    public Seamen(String id, String name, int age) {
        super(id, name, age);
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
