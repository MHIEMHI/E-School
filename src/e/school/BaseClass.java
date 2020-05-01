/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.io.IOException;
import java.io.OptionalDataException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public abstract class BaseClass
{
    private String key;
    private String source;
    private static RecordsFile recordsFile;
    private int initialSize;
    
    private BaseClass()
    {
        setKey();
        setSource();
        initialSize = 64;
        setRecordsFile();
    }
    
    private BaseClass(int initialSize)
    {
        setKey();
        setSource();
        this.initialSize = initialSize;
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
                recordsFile = new RecordsFile(source, initialSize);
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
        source = this.getClass().getSimpleName() + ".jdb";
    }

    public String getSource()
    {
        return source;
    }
    
    public void insert() throws IOException, RecordsFileException
    {
        RecordWriter rw = new RecordWriter(key);
        rw.writeObject(this);
        recordsFile.insertRecord(rw);
    }
    
    public Object read()
    {
        Object d = null;
        try
        {
            RecordReader rr = recordsFile.readRecord(key);
            d = rr.readObject();
        }
        catch (Exception ex)
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("last access was at: " + d.toString());
        return d;
    }
}
