/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.principal.Actividad;

/**
 *
 * @author Jaime
 */
public class ManejoArchivos {

    /**
     * Guarda la configuración del objeto Usuario en un archivo .bin
     * @param ob
     * @param ruta 
     */
    public void guardarDatos(Object ob, String ruta) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(ruta);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(ob);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    /**
     * Carga los datos de un archivo .bin con la configuracion del objeto Usuario
     * @param ruta
     * @return 
     */
    public  Object recuperarDatosUsuario(String ruta){
        Object aux = null;
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(fis);
            
            aux = (Object)in.readObject();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
    /**
     * Carga los objetos Actividad existentes dentro de un archivo .bin
     * @param ruta
     * @return ArrayList<Actividad>
     */
  public ArrayList<Actividad> recuperarActividades(String ruta) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        try {
            File f1 = new File(ruta);
            FileInputStream fo1 = new FileInputStream(f1);
            try (
                ObjectInputStream ois = new ObjectInputStream(fo1)) {
                Object aux = (Object)ois.readObject();
                while (aux != null) {
                    if (aux instanceof Actividad) {
                        Actividad act = (Actividad) aux;
                        actividades.add(act);
                    }
                    aux = ois.readObject();
                }
                ois.close();
            }
        } catch (EOFException e1) {
//            e1.printStackTrace();
        } catch (IOException | ClassNotFoundException e2) {
            e2.getMessage();
        }
        return actividades;
    }
  /**
   * Guarda los objetos Actividad dentro de un archivo .bin 
   * @param actividades
   * @param ruta 
     * @return  
   */
    public boolean almacenarActividades(ArrayList<Actividad> actividades, String ruta) {
        FileOutputStream fo = null;
        boolean error = false;
        try {

            File f = new File(ruta);
            fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            for (Actividad act : actividades) {
                oo.writeObject((Object)act);
            }

        } catch (IOException e) {
            e.getMessage();
            error = true;
        } finally {
            try {
                fo.close();
            } catch (IOException ex) {
                error = true;
            }
        }
        return error;
    }
}
