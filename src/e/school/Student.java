/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

/**
 *
 * @author meh25
 */
public class Student extends Person
{
    private String cne ;
    private String ville ;

    public Student()
    {
            super();
    }

    public Student(String cin, String nom, String prenom, String cne, String ville)
    {
        super(cin, nom, prenom);
        this.cne = cne;
        this.ville = ville;
    }
    
    public Student(String cin, String nom, String prenom, String email, String cne, String ville)
    {
        super(cin, nom, prenom, email);
        this.cne = cne;
        this.ville = ville;
    }

    public String getCne()
    {
            return cne;
    }
    
    public void setCne(String cne)
    {
            this.cne = cne;
    }
    
    public String getVille()
    {
            return ville;
    }
    
    public void setVille(String ville)
    {
            this.ville = ville;
    }

    @Override
    public String toString() {
            return "Etudiant [key=" + this.key + ", CIN= " + getCin()+ ", Nom " + getNom() + " Prenom" + getPrenom() + "cne=" + cne +  ", Email \r\n" 
        + getEmail()+ ", ville=" + getVille() + "]";
    }
}