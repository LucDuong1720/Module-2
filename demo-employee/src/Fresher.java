import java.util.Date;

public class Fresher extends Employee {
    private Date graduationDate;

    private String graduationRank;

    private String education;

    public Fresher() {

    }
    public Fresher(Date graduationDate, String graduationRank, String education) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(long id, String fullName, Date birthDay, String phone, String email,
                   EmployeeType employeeType, Date graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(long id, String fullName, Date date, String phone, String email, EmployeeType fresher) {
        super(id, fullName, date, phone, email, fresher);
    }
    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}