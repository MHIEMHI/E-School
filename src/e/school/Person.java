/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

/**
 *
 */

public class Person extends JdbObject
{
    private String cin;
    private String nom;
    private String prenom;
    private String email;

    public Person()
    {
        super();
    }
    
    public Person(String cin, String nom, String prenom)
    {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Person(String cin, String nom, String prenom, String email)
    {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    
    public String getCin()
    {
        return this.cin;
    }

    public void setCin(String cin)
    {
        this.cin = cin;
    }
    
    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Personne [key=" + this.key + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
    }
}

