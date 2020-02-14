/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdellatif
 */
public class Memento {

//       private static Library instance = new Library();
//     public static Library getInstance() {
//        if (instance == null) {
//            setInstance(new Library());
//        }
//        return instance;
//    }
    public boolean TakeSnapShot(String filename) {

        try {
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(f);
            Library l = Library.getInstance();
            out.writeObject(l);
            out.close();
            f.close();

            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Library getSnapShot(String filename) {
        try {
            FileInputStream f = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(f);
            Library obj = (Library) in.readObject();
            in.close();
            f.close();
            return obj;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * @param aInstance the instance to set //
     */
//    public static void setInstance(Library aInstance) {
//        instance = aInstance;
//    }
}
