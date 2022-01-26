package peaksoft;

import peaksoft.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static final Scanner sc=new Scanner(System.in);
    public static final Scanner sc1=new Scanner(System.in);
    public static void main( String[] args ){
        byte number= sc.nextByte();
              Employee employee=  new Employee("Rahim","Kurbanov", (byte) 18);
switch (number){
    case 1:
        System.out.println(Employee.create(employee));
        break;
    case 2:
        System.out.println(Employee.getById(number));
        break;
    case 3:
        System.out.println("id");
        long id=sc.nextLong();
        System.out.println("name");
        String name=sc1.nextLine();
        System.out.println("surname");
        String surname=sc1.nextLine();
        System.out.println("age");
        byte age=sc.nextByte();
        Employee.upDate((int) id,name,surname,age);
        break;
    case 4:
        Employee.getAllStudents().forEach(System.out::println);
        break;
    case 5:
        Employee.getAllStudents1().forEach(System.out::println);
        break;
    case 6:
        Employee.employee();
        break;
    case 7:
        Employee.removeEmpoyee();
        break;
    default:
        System.out.println("bashka san jok");
}
    }
}
