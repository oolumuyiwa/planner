package edu.vassar.cmpu203.plannerapp.persistence;

import android.content.Context;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.controller.MainActivity;

public class Persistence implements  IPersistenceFacade{
    // variable to hold context
    private Context context;

//save the context recievied via constructor in a local variable

    public Persistence(Context context){
        this.context=context;
    }

    public void serializeArrayList(List<Course> courses) {
        try {
            FileOutputStream fos
                    = new FileOutputStream("courses");

            // an ObjectOutputStream object is
            // created on the FileOutputStream
            // object
            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);

            // calling the writeObject()
            // method of the
            // ObjectOutputStream on the
            // OutputStream file "namesList"
            oos.writeObject(courses);

            // close the ObjectOutputStream
            oos.close();

            // close the OutputStream file
            fos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses(){
        ArrayList<Course> courses = new ArrayList<Course>();

        try
        {
            FileInputStream fis = new FileInputStream("courses");
            ObjectInputStream ois = new ObjectInputStream(fis);

            courses = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();

        }
        catch (ClassNotFoundException c)
        {
            c.printStackTrace();
        }
        return courses;
    }


    public void writeToFile(String fileName, String content){
        File path = context.getFilesDir();
        try {
            File f1  = new File(path, fileName);
            FileUtils.writeStringToFile(f1,"\n" + content, Charset.defaultCharset());
            Toast.makeText(context, "File written:" + fileName, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String fileName){
        File path = context.getFilesDir();
        File readFrom = new File(path, fileName);
        byte[] content = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);
            return new String(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

}
