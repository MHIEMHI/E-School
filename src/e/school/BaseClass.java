/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.logging.*;
import java.lang.reflect.Type;
/**
 *
 * @param <Jdb>
 */
public class BaseClass <Jdb extends JdbObject> 
{
    private final Class<Jdb> jdb;
    private transient String source;
    private static transient RecordsFile recordsFile;
    private transient int initialSize;
    
    
    public BaseClass(Class<Jdb> jdb)
    {
        this.jdb = jdb;
        setSource();
        initialSize = 64;
        setRecordsFile();
    }
        
    public BaseClass(Class<Jdb> jdb, int initialSize)
    {
        this.jdb = jdb;
        setSource();
        this.initialSize = initialSize;
        setRecordsFile();
    }
    
    protected String getGenericName()
    {
        return jdb.getSimpleName();
    }
    
    private void setSource()
    {
        source = getGenericName() + ".jdb";
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
    
    public List<Object> getAll()
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
    
    public void insert(JdbObject jdb)
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
