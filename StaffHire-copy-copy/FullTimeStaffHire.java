public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private int weeklyFractionalHours;

    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, 
                             String joiningDate, String qualification, String appointedBy, boolean joined, 
                             double salary, int weeklyFractionalHours) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    public void setSalary(double newSalary) {
        if (isJoined()) {
            salary = newSalary;
        } else {
            System.out.println("No staff appointed to set the salary.");
        }
    }

    public void setWeeklyFractionalHours(int hours) {
        weeklyFractionalHours = hours;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}
