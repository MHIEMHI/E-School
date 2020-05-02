/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 */
public abstract class BaseClass implements Serializable 
{
    private String key;
    
    private transient String source;
    private static transient RecordsFile recordsFile;
    private transient int initialSize;
    
    public BaseClass()
    {
        setKey();
        setSource();
        initialSize = 64;
        setRecordsFile();
    }
        
    public BaseClass(int initialSize)
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
    
    public List<Object> getAll()
    {
        Enumeration<String> keys = recordsFile.enumerateKeys();
        List<Object> values = new ArrayList<Object>();
        while(keys.hasMoreElements())
        {
            try
            {
                values.add(recordsFile.readRecord(keys.nextElement()));
            } 
            catch (Exception ex)
            {
                Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return values;
    }
    
    public void insert()
    {
        try
        {
            RecordWriter rw = new RecordWriter(key);
            rw.writeObject(this);
            recordsFile.insertRecord(rw);
        }
        catch (Exception ex)
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void update()
    {
        try
        {
            RecordWriter rw = new RecordWriter(key);
            rw.writeObject(this);
            recordsFile.updateRecord(rw);
        }
        catch (Exception ex)
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete()
    {
        try
        {
            recordsFile.deleteRecord(key);
        }
        catch (Exception ex)
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
