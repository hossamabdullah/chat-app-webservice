/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.utility;

import com.sun.jersey.core.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Hossam Abdallah
 */
public class FileManagementUtility {
    public static boolean convertFile(String file_string, String file_name , String path) throws IOException{
        try{
            byte[] bytes = Base64.decode(file_string);
            File file = new File(path+file_name);
            FileOutputStream fop = new FileOutputStream(file);
            fop.write(bytes);
            fop.flush();
            fop.close();
            return true;
        }catch(IOException exception){
            System.out.println(exception.toString());
            return false;
        }
    }
}
