import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class EmployeeComparable implements Comparable<EmployeeComparable>
{
    private String name;
    private Integer salary;
    private final LocalDateTime workStart;


    public EmployeeComparable(String name, Integer salary) //, Date workStart)
    {
        this.name = name;
        this.salary = salary;
        //this.workStart = workStart;
        workStart = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeComparable employee1 = (EmployeeComparable) o;
        return name.equals(employee1.name) && salary.equals(employee1.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString()
    {
        return name + " - " + salary + " - " + workStart;
                //+
            //(new SimpleDateFormat("dd.MM.yyyy")).format(workStart);
    }

    public LocalDateTime getTime() {
        return this.workStart;
    }


    @Override
    public int compareTo(EmployeeComparable o) {
//        return this.getTime().compareTo(o.workStart);
        return this.getName().compareTo(o.getName());
    }
}
