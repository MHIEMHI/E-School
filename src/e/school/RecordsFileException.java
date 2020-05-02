/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.school;

/**
 * RecordsFileException is a simple exception class that indicates that 
 * an error has occurred while performing an operation on the records file.
 */
  public class RecordsFileException extends Exception
  {
    public RecordsFileException (String msg)
    {
      super(msg);
    }
  }
