/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

/**
 *
 * @author Jaime
 */
public class ManejoArchivos {

    public ManejoArchivos() {
    }

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

    public Object cargarDatos(String ruta) {
        Object aux = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(fis);

            aux = (Object) in.readObject();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aux;
    }

    public ArrayList<Actividad> CargarActvidades(String ruta) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        try {
            File f1 = new File(ruta);
            FileInputStream fo1 = new FileInputStream(f1);
            try (ObjectInputStream ois = new ObjectInputStream(fo1)) {
                Object aux = ois.readObject();
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
        } catch (IOException | ClassNotFoundException e2) {
            e2.getMessage();
        }
        return actividades;
    }

    public void almacenarActividades(ArrayList<Actividad> actividades, String ruta) {
        FileOutputStream fo = null;
        try {

            File f = new File(ruta);
            fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            for (Actividad act : actividades) {
                oo.writeObject(act);
            }

        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                fo.close();
            } catch (IOException ex) {
                Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
