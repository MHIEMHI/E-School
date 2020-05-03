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
        boolean appFlag = true ;
        boolean adminFlag = true ;

              
        BaseClass<Student> students = new BaseClass<Student>();
        
        while(appFlag)
        {
            try
            {
		System.out.println("********************Gestion des étudiant*********************");
		System.out.println("Menu Principal");
		
		System.out.println("1)  Administrateur");
		System.out.println("2)  Étudiant");
		
		System.out.println("choix : ");
		Scanner scanner=new Scanner(System.in);
		int choix = scanner.nextInt();
                
		switch(choix)
                {
                    case 1 :
                    {
                        while(adminFlag)
                        {
                            System.out.println("********************Bienvenu entant que administrateur *********************");
                            System.out.println("1)  Gestion des etudiants ");
                            System.out.println("2)  Gestion des enseignants ");
                            System.out.println("3)  Gestion des fili�res");
                            System.out.println("4)  Gestion des responsables");
                            System.out.println("5)  Gestion des Modules");
                            System.out.println("6)  Remplir la filiere apres la creation des modules et de responsable et des etudiant");
                            System.out.println("7)  Completet l'inscription de l'etudiant dans la FiliereComplet");
                            System.out.println("8)  QUITTER");
                            int choixEtudiant = scanner.nextInt();
                            switch(choixEtudiant)
                            {
                                case 1 :
                                {
                                    System.out.println("*******************Gestion des etudiants******************** ");
                                    boolean studentFlag = true ;
                                    Student etudiant = new Student();
                                    while(studentFlag)
                                    {
                                        try
                                        {
                                            System.out.println("Donnez le ID de l'�tudiant");				
                                            etudiant.setCin(scanner.next());
                                            studentFlag = false;
                                        }
                                        catch (InputMismatchException e)
                                        {
                                            System.out.println("il ya une execption de type  " +e+  "   veuillez entrez un int ");

                                            scanner.nextLine();
                                        }
                                    }
                                    
                                    System.out.println("Donnez le nom de l'�tudiant");
                                    etudiant.setNom(scanner.next());
                                    System.out.println("Donnez le prenom de l'�tudiant");
                                    etudiant.setPrenom(scanner.next());
                                    System.out.println("Donnez la ville de l'�tudiant");
                                    etudiant.setVille(scanner.next());
                                    System.out.println("Donnez le CNE de l'�tudiant");
                                    etudiant.setCne(scanner.next());
                                    System.out.println("Donnez le EMAIL de l'�tudiant");
                                    etudiant.setEmail(scanner.next());
                                    System.out.println("voila l'etudiant que vous avez creer \n"+etudiant);
                                }

                            }
			    
			    	
			    
		       
				break;
                        }
                    }

                }
            }
            catch(Exception e)
            {

            }
        }
    }
    
}
