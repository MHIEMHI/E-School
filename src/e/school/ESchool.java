/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author meh25
 */
public class ESchool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        try
        {

            System.out.println("Reading input from console using Scanner in Java ");
            int number;
            String name ;
            String cin ;
            String cen ;
            
            Students s1 = new Students();


            do
            {
                System.out.println("Please enter your input: ");
                System.out.println("Reading int from console in Java: ");
                System.out.println("1 : Insert");
                System.out.println("2 : Read");
                System.out.println("3 : Update");
                System.out.println("4 : Delete");
                System.out.println("5 : getAll");

                System.out.println("0 : Exit");

                
                number = scanner.nextInt();
                System.out.println("Enter student name: " + number);
                
                switch(number)
                {
                    case 1 :
                    {

                        name = scanner.next();
                        System.out.println("Enter student name: " + name);
                        cin = scanner.next();
                        System.out.println("Enter student cin: " + cin);
                        cen = scanner.next();
                        System.out.println("Enter student cen: " + cen);
                        s1 = new Students(name, cin, cen);
                        System.out.println("Student" + s1.toString());
                        
                        s1.insert();
                    }
                    break;
                    case 2 :
                    {
                        Students s2 = (Students) s1.read();
                        System.out.println("last access was at: " + s2.toString());
                    }
                    break;
                    case 3 :
                    {
                        
                        name = scanner.next();
                        System.out.println("Enter student name: " + name);
                        cin = scanner.next();
                        System.out.println("Enter student cin: " + cin);
                        cen = scanner.next();
                        System.out.println("Enter student cen: " + cen);
                        s1.name = name;
                        s1.cin = cin;
                        s1.cne = cen;
                        System.out.println("Student" + s1.toString());
                        
                        s1.update();
                    }
                    break;
                    case 4 :
                    {
                        s1.delete();
                    }
                    break;
                    case 5 :
                    {
                        List<Object> students = Students.getAll();
                        for (Object arg : students)
                        {
                            Students s = (Students)arg;
                            System.out.println("Students : " + s.toString());
                            System.out.println("Students : " );
                        }

                    }
                    break;
                    case 0:
                    default:
                    break;
                }
            }while (number != 0);
        }
        catch(Exception e)
        {
            
        }
    }
    
}
