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
public class ESchool
{
    BaseClass<Student> students;

    public ESchool()
    {
        students = new BaseClass<Student>(Student.class);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ESchool app = new ESchool();
        boolean appFlag = true ;
        boolean adminFlag = true ;
        boolean etudiantFlag = true ;

        
        while(appFlag)
        {
            try
            {
		System.out.println("********************Gestion des étudiant*********************");
		System.out.println("Menu Principal");
		
		System.out.println("1)  Administrateur");
		System.out.println("2)  Étudiant");
		
		System.out.println("choix : ");
		Scanner scanner = new Scanner(System.in);
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
                            int choixGestion = scanner.nextInt();
                            switch(choixGestion)
                            {
                                case 1 :
                                {
                                    while (etudiantFlag)
                                    {                                        
                                        System.out.println("*******************Gestion des etudiants******************** ");
                                        System.out.println("1)  Ajout étudiant ");
                                        System.out.println("2)  Afficher tous les étudiants ");
                                        System.out.println("8)  QUITTER ");
                                        int choixEtudiant = scanner.nextInt();
                                        switch(choixEtudiant)
                                        {
                                            case 1 :
                                            {
                                                app.ajouterEtudiant();
                                            }
                                            break;
                                            case 2 :
                                            {
                                                app.afficherEtudiants();
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            catch(Exception e)
            {

            }
        }
    }
    
    public void ajouterEtudiant()
    {
        Scanner scanner = new Scanner(System.in);

        Student etudiant = new Student();

        System.out.println("Donnez le CIN de l'étudiant");				
        etudiant.setCin(scanner.next());
        System.out.println("Donnez le nom de l'étudiant");
        etudiant.setNom(scanner.next());
        System.out.println("Donnez le prenom de l'étudiant");
        etudiant.setPrenom(scanner.next());
        System.out.println("Donnez la ville de l'étudiant");
        etudiant.setVille(scanner.next());
        System.out.println("Donnez le CNE de l'étudiant");
        etudiant.setCne(scanner.next());
        System.out.println("Donnez le EMAIL de l'étudiant");
        etudiant.setEmail(scanner.next());
        System.out.println("voila l'étudiant que vous avez creer :\n"+etudiant);
        
        this.students.insert(etudiant);
    }
    
    public void afficherEtudiants()
    {
        for (Object arg : this.students.getAll())
        {
            Student s = (Student)arg;
            System.out.println(s.toString());
        }
    }
}
