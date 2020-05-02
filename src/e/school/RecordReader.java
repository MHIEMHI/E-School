/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

import java.io.*;

public class RecordReader
{
    
  /**
   * The record's key
   */
  String key;
  
  /**
   * Byte buffer that holds the record data
   */
  byte[] data;

  /**
   * ByteArrayInputStream for reading the record data
   */
  ByteArrayInputStream in;

  /**
   * ObjectInputStream used for reading serialized objects from the record
   */
  ObjectInputStream objIn;

  /**
   * The constructor initializes the key and data fields and then creates the ByteArrayInputStream off of the data buffer.
   */
  public RecordReader(String key, byte[] data)
  {
    this.key = key;
    this.data = data;
    in = new ByteArrayInputStream(data);
  }
  
  public String getKey()
  {
    return key;
  }
  
  public byte[] getData()
  {
    return data;
  }
  
  /**
   * This method returns an input stream for reading fields from the record.
   */
  public InputStream getInputStream() throws IOException
  {
    return in;
  }
  
  /**
   * This method returns an ObjectOutputStream for reading serialized objects.
   * The user should use either this method or the getInputStream() method for reading data -- mixed access will produce undefined results.
   */
  public ObjectInputStream getObjectInputStream() throws IOException
  {
    if (objIn == null)
    {
      objIn = new ObjectInputStream(in);
    }
    return objIn;
  }
  
  /**
   * Reads the next object in the record using an ObjectInputStream.
   */
  public Object readObject() throws IOException, OptionalDataException, ClassNotFoundException
  {
    return getObjectInputStream().readObject();
  }
}