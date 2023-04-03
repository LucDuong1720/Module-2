public enum EmployeeType {
    Experience(0), Fresher(1), Intern(2);
    private int id;
    private EmployeeType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        System.out.println(EmployeeType.Experience);

        for(EmployeeType e : values()){
            System.out.println(e + " - " + e.getId());
        }
    }
}