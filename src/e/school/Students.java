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
public class Students extends BaseClass
{
    String name;
    String cin;
    String cne;
    
    public Students()
    {
        super();
    }
    
    public Students(String name, String cin, String cne)
    {
        super();
        this.name = name;
        this.cin = cin;
        this.cne = cne;
    }
    
    public String toString()
    {
        return this.getkey() + ':' + this.name + ' ' + this.cin + ' ' + this.cne;
    }
}
