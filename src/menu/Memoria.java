/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import exploradordelavida.logic.Board;
import exploradordelavida.logic.Cell;
import exploradordelavida.logic.Position;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

/**
 *
 * @author EDER H
 */
public class Memoria implements java.io.Serializable{
    private Board memorisa;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setMemorisa(Board memorisa) {
        this.memorisa = memorisa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Memoria(){
        this.memorisa= new Board(25);
    }

    public Board getMemorisa() {
        return memorisa;
    }
    //---------------Metodo para abrir partidas-------------------------------- 
    public void abrir() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fINombre = new FileInputStream(this.nombre);
        ObjectInputStream oILector = new ObjectInputStream(fINombre);
        this.memorisa =  (Board) oILector.readObject();
        
        oILector.close();
        fINombre.close();
    }
    //---------------Metodo para guardar partidas----------------------------
    public void guardar() throws IOException{
        FileOutputStream fileStream = new FileOutputStream(this.nombre + ".EJI");
        ObjectOutputStream OS = new ObjectOutputStream(fileStream);
        OS.writeObject(this.memorisa);
        OS.close();
        fileStream.close();
            
        }
    
    }

