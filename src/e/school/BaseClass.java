/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.util.UUID;

/**
 *
 */
public abstract class BaseClass
{
    private String key;
    private String source;
    private RecordsFile recordsFile;
    
    private BaseClass()
    {
        setKey();
        setSource();
        setRecordsFile();
    }
    
    private void setRecordsFile()
    {
        try
        {
            recordsFile = new RecordsFile(source, "rw");
        }
        catch(Exception e)
        {
            try
            {
                recordsFile = new RecordsFile(source, 64);
            }
            catch(Exception ex)
            {
                System.out.println("Error occured: " + ex);
                System.exit(0);
            }
        }
    }
    
    public RecordsFile getRecordsFile()
    {
        return recordsFile;
    }
    
    private void setKey()
    {
        key = UUID.randomUUID().toString();
    }

    public String getkey()
    {
        return key;
    }
    
    private void setSource()
    {
        source = this.getClass().getSimpleName();
    }

    public String getSource()
    {
        return source;
    }
    
    public void insert()
    {
        //WIP
    }
    
}
