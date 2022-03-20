public class Student extends Person {
    private int id;
    private String major;

    public Student() {
        super();
        this.id = 0;
        this.major = "none";
    }

    public Student(String name, String address, String phone, String email, int id, String major) {
        super(name, address, phone, email);
        this.id = id;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String toString() {
        return super.toString() + "ID: " + id + "\n" + "Major: " + major + "\n";
    }

}
