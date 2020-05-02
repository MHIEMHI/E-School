/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

/**
 *
 */

public class Person extends BaseClass
{
	private int id;
	private String nom;
	private String prenom;
	private String email;

	public Person(int id, String nom, String prenom)
        {
            super();
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
	}

	public Person()
        {
            super();
	}

	public Person(String nom, String prenom, String email)
        {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Person(String nom, String prenom)
        {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId()
        {
		return id;
	}

        public void setId(int id)
        {
		this.id= id;
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
		return "Personne [cin=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
}

