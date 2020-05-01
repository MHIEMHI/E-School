/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.io.*;
import java.util.*;

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
            RecordsFile recordsFile = new RecordsFile("testDatabase.jdb", 64);

            System.out.println("Reading input from console using Scanner in Java ");
            int number ;
            do
            {
                System.out.println("Please enter your input: ");
                System.out.println("Reading int from console in Java: ");
                System.out.println("1 : Insert");
                System.out.println("2 : Read");
                System.out.println("3 : Update");
                System.out.println("4 : Delete");
                System.out.println("0 : Exit");

                number = scanner.nextInt();
                System.out.println("Integer input: " + number);

                switch(number)
                {
                    case 1 :
                    {
                        RecordWriter rw = new RecordWriter("foo.lastAccessTime");
                        rw.writeObject(new Date());
                        recordsFile.insertRecord(rw);
                    }
                    break;
                    case 2 :
                    {
                        RecordReader rr = recordsFile.readRecord("foo.lastAccessTime");
                        Date d = (Date)rr.readObject();
                        System.out.println("last access was at: " + d.toString());
                    }
                    break;
                    case 3 :
                    {
                        RecordWriter rw = new RecordWriter("foo.lastAccessTime");
                        rw.writeObject(new Date());
                        recordsFile.updateRecord(rw);
                    }
                    break;
                    case 4 :
                    {
                        recordsFile.deleteRecord("foo.lastAccessTime");
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
