/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.util.Set;
import java.util.UUID;

/**
 *
 * @author meh25
 */
public class JdbObject 
{
    public String key;
    
    public JdbObject()
    {
        setKey();
    }
    
    private void setKey()
    {
        key = UUID.randomUUID().toString();
    }

    public String getkey()
    {
        return key;
    }
    
    private String getSource()
    {
       return this.getClass().getSimpleName() + ".jdb";
    }
}
