package top5v2;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONObject;
import java.io.IOException;

public class MainModel {
    List<String> fiveShown;
    List<Object> businesses;
    
    public MainModel() {
        fiveShown = new ArrayList<>();
        businesses = new ArrayList<>();
        
        try {
            Scanner newFile = new Scanner(Paths.get("settings.txt"));
            while(newFile.hasNextLine()) {
                String category = newFile.nextLine();
                fiveShown.add(category);
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
   
        for(int i = 0; i < 5; i++) {
            businesses.add(new JSONObject());
        }    
    }
    
    public void adjustModel(){
        try{
            Scanner newFile = new Scanner(Paths.get("settings.txt"));
            for (int i = 0; i < 6; i++){
                String category = newFile.nextLine();
                fiveShown.set(i, category);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getLocation() {
        return fiveShown.get(5);
    }
    
    public void editList(int index, String newEntry) {
        fiveShown.set(index, newEntry);
    }
    
    public List<String> returnStartList() {
        ArrayList returned = (ArrayList) fiveShown;
        return returned;
    }
    
    public List<JSONObject> returnList() {
        ArrayList returned = (ArrayList) businesses;
        return returned;
    }
    
    public void editMainList(int index, JSONObject business) {
        businesses.set(index, business);
    }
}
