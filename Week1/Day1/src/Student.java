import java.util.Comparator;

public class Student implements Comparable<Student> {
    String firstName;
    String secondName;
    String email;
    int credits;
    double gpa;

    public Student(String firstName, String secondName, String email, int credits, double gpa) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.credits = credits;
        this.gpa = gpa;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public int getCredits() {
        return credits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", credits=" + credits +
                ", gpa=" + gpa +
                '}';
    }


    public int compareTo(Student s) {
        return Comparator.comparing(Student::getGpa).thenComparing(Student::getSecondName).compare(this, s);
    }


}
