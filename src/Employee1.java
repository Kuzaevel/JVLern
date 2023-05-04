import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Employee1
{
    private String name;
    private Integer salary;
    private Date workStart;

    public Employee1(String name, Integer salary) //, Date workStart)
    {
        this.name = name;
        this.salary = salary;
//        this.workStart = workStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
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

    public Date getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Date workStart) {
        this.workStart = workStart;
    }

    public String toString()
    {
        return name + " - " + salary + " - ";
            //+
            //(new SimpleDateFormat("dd.MM.yyyy")).format(workStart);
    }
}
