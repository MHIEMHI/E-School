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
 * @param <Jdb>
 */
public class BaseClass <Jdb extends JdbObject> 
{
    private Jdb jdb;
    
    private transient String source;
    private static transient RecordsFile recordsFile;
    private transient int initialSize;
    
    public BaseClass()
    {
        setSource();
        initialSize = 64;
        setRecordsFile();
    }
        
    public BaseClass(int initialSize)
    {
        setSource();
        this.initialSize = initialSize;
        setRecordsFile();
    }
    
    private void setSource()
    {
        source = jdb.getClass().getSimpleName() + ".jdb";
    }

    public String getSource()
    {
        return source;
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
    
    public static List<Object> getAll()
    {
        Enumeration<String> keys = recordsFile.enumerateKeys();
        List<Object> values = new ArrayList<Object>();
        while(keys.hasMoreElements())
        {
            try
            {
                values.add(recordsFile.readRecord(keys.nextElement()).readObject());
            } 
            catch (Exception ex)
            {
                System.out.println("e.school.BaseClass.getAll()" + ex);
            }
        }
        return values;
    }
    
    public void insert(Jdb jdb)
    {
        try
        {
            RecordWriter rw = new RecordWriter(jdb.key);
            rw.writeObject(jdb);
            recordsFile.insertRecord(rw);
        }
        catch (Exception ex)
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object read(String key)
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
        return d;
    }
    
    public void update(String key, Jdb jdb)
    {
        try
        {
            RecordWriter rw = new RecordWriter(key);
            rw.writeObject(jdb);
            recordsFile.updateRecord(rw);
        }
        catch (Exception ex)
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String key)
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
