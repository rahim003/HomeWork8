package peaksoft.entity;

import org.hibernate.Session;
import peaksoft.Util.Hibernate;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private byte age;

    public Employee(String name, String surname, byte age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public static int create(Employee employee) {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        return employee.getId();
    }

    public static Employee getById(int id1) {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id1);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    public static Employee upDate(int id, String name, String lastName, int age) {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        Employee employee1 = session.get(Employee.class, id);
        employee1.setId(id);
        employee1.setName(name);
        employee1.setSurname(lastName);
        employee1.setAge((byte) age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Update");
        return employee1;
    }

    public static List<Employee> getAllStudents() {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        List<Employee> students = session.createQuery("from  Employee ").getResultList();
        session.getTransaction().commit();
        System.out.println("Finded: " + students.size() + "students");
        return students;
    }

    public static List<Employee> getAllStudents1() {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        List<Employee> employees1 = session.createQuery(" from  Employee where name='Aza'and age>20").getResultList();
        session.getTransaction().commit();
        System.out.println("Finded: " + employees1.size() + "students");
        return employees1;
    }

    public static void employee() {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        session.createQuery("update Employee  set age =18 where name like 'Aza'").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static void removeEmployee() {
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Employee where name='Aza'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
