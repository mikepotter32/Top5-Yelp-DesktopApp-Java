package top5v2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.net.URI;
import java.net.URL;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class MainPageController {
    Version2 main;
    MainModel model;
    URI websiteURL;
    Settings settingsPage;
    private static final String CONSUMER_KEY = "JCZ76d4n9SSz0zjjS_-B6A";
    private static final String CONSUMER_SECRET = "YZ0njyTG3scahdIBewsT2ESQ4cY";
    private static final String TOKEN = "P8uMKZJ7iq0dwSIPyiC94D0ogMvCpbGd";
    private static final String TOKEN_SECRET = "fU4fXDWbrsTPQoog3HJQleQ5YX4";

    public void changeSettings(String s) {
        Charset charset = Charset.forName("US-ASCII");
        OpenOption[] options = new OpenOption[2];
        options[0] = StandardOpenOption.TRUNCATE_EXISTING;
        options[1] = StandardOpenOption.WRITE;
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("settings.txt"), charset,options)) {
            writer.write(s, 0, s.length());
        } catch (IOException x) {
              System.err.format("IOException: %s%n", x);
        }
    }
    
    public void resetMainPage() {
        model.adjustModel();
        URL rating = null;
        ArrayList<URL> ratings = new ArrayList<>();
        List<String> words = model.returnStartList();
        for (int j = 0; j < 5; j++) {
            JSONObject results = getTopResult(words.get(5), words.get(j), 500);
            model.editMainList(j, results);
            try {
                rating = new URL(results.get("rating_img_url").toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ratings.add(rating);
            String result = results.get("name").toString();
            main.setPanel(j, result);
        }
        
        main.setRatings(ratings);
    }
    
    
    public JSONObject getTopResult(String location,String term,int radius) {
        QueryBot query = new QueryBot(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET); // creates new queryBot which holds our authentication and makes the calls to yelps databases
        query.changeSearchConditions(term, location, radius);
        QueryBot.YelpAPICLI yelp = new QueryBot.YelpAPICLI();
        JSONArray results = query.queryAPI(query, yelp);
        JSONObject firstBusiness = (JSONObject) results.get(0);
        return firstBusiness;
    }
    
    public JSONArray getTop5Results(String location, String term, int radius){
        QueryBot query = new QueryBot(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
        query.changeSearchConditions(term, location, radius);
        QueryBot.YelpAPICLI yelp = new QueryBot.YelpAPICLI();
        JSONArray results = query.queryAPI(query, yelp);
        return results;
    }
    
    public String getResultString(JSONObject business){
        return business.get("name").toString();
    }
    
    public void initMainPage() {
        URL rating = null;
        ArrayList<URL> ratings = new ArrayList<>();
        List<String> words = model.returnStartList();
        for (int j = 0; j < 5; j++) {
            JSONObject results = getTopResult(words.get(5), words.get(j), 500);
            model.editMainList(j, results);
            try {
                rating = new URL(results.get("rating_img_url").toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ratings.add(rating);
            String result = results.get("name").toString();
            main.setPanel(j, result);  
        }
        
        main.setRatings(ratings);
        
        main.addRestaurantButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Restaurants"));
                    getNames.start();
                }
            }
        );
        
        main.addShoppingButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Shopping"));
                    getNames.start();
                }
            }
        );
        
        main.addBarsButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Bars"));
                    getNames.start();
                }
            }
        );
        
        main.addTheatresButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Theatres"));
                    getNames.start();
                }
            }
        );
        
        main.addHotelsButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Hotels"));
                    getNames.start();
                }
            }
        );
        
        main.addCoffeeButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread  getNames = new Thread(new JButtonThread("Coffee"));
                    getNames.start();
                }
            }
        );
        
        main.addDinnerButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Dinner"));
                    getNames.start();
                }
            }
        );
        
        main.addLunchButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Lunch"));
                    getNames.start();
                }
            }
        );
        
        main.addBreakfastButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Breakfast"));
                    getNames.start();
                }
            }
        );
        
        main.addParkButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Parks"));
                    getNames.start();
                }
            }
        );
        
        main.addArtsButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Arts & Crafts"));
                    getNames.start();
                }
            }
        );
        
        main.addSpaButtonActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getNames = new Thread(new JButtonThread("Beauty & Spa"));
                    getNames.start();
                }
            }
        );
        
        main.addLinkButtonListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    open(websiteURL);
                }
            }
        );
        
        main.addButtonOneListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getDetails = new Thread(new detailsThread(0));
                    getDetails.start();
                }
            }
        );
        
        main.addButtonTwoListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getDetails = new Thread(new detailsThread(1));
                    getDetails.start();
                }
            }
        );
        
        main.addButtonThreeListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getDetails = new Thread(new detailsThread(2));
                    getDetails.start();
                }
            }
        );
        
        main.addButtonFourListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getDetails = new Thread(new detailsThread(3));
                    getDetails.start();
                }
            }
        );
        
        main.addButtonFiveListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread getDetails = new Thread(new detailsThread(4));
                    getDetails.start();
                }
            }
        );
        
        main.addSettingsListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    settingsPage.setVisible(true);
                }
            }
        );
        
        settingsPage.addOKButtonListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    Thread settings = new Thread(new SettingsThread());
                    settings.start();       
                } 
            }
        );
    }
    
    private static void open(URI uri){
        if (Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().browse(uri);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void setDetails(int panel) {
        URL ratingURL = null;
        URL imageURL = null;
        
        JSONObject business = model.returnList().get(panel);
        try {
            String url = business.get("image_url").toString();
            imageURL = new URL(url);
            String review = business.get("snippet_text").toString(); 
            main.setReview(review);
            main.setImage(imageURL);
        } catch (NullPointerException | IOException e){
            ImageIcon icon = new ImageIcon(getClass().getResource("/top5v2/pictures/SorryNoImageAvailable.png"));
            main.setImage(icon);
            main.setReview("No Reviews");
            
        }
        String rating = business.get("rating_img_url_large").toString();
        HashMap location = (HashMap) business.get("location");
        String address = location.get("display_address").toString();
        String name = business.get("name").toString();
        String website = business.get("url").toString();
        Long reviewCount = (Long) business.get("review_count");

        main.setName(name);
        main.setWebsite(website);
        websiteURL = URI.create(website);
        main.setReviewCount(reviewCount);
        
        try {
            String phone = business.get("display_phone").toString();
            main.setPhone(phone);
        } catch (NullPointerException e) {
            main.setPhone("No Phone #");
        }  
        
        try {
            ratingURL = new URL(rating);
            main.setNewGoogle(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        main.setRating(ratingURL);
      
    }
    
    public void setPage(String word){
        String location = model.getLocation();
        JSONArray results = getTop5Results(location, word, 500);
        URL ratingURL = null;
        ArrayList<URL> ratings = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            JSONObject test = (JSONObject) results.get(i);
            try {
                ratingURL = new URL(test.get("rating_img_url").toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ratings.add(ratingURL);
            main.setPanel(i, getResultString((JSONObject) results.get(i)));
            model.editMainList(i, (JSONObject)results.get(i));
       }
        main.setRatings(ratings);
    }
    
    private class detailsThread extends Thread {
        private int panel;
        
        public detailsThread(int panel){
            this.panel = panel;
        }
        
        @Override
        public void run(){
            setDetails(panel);
        }
    }
    
    private class SettingsThread extends Thread {
        @Override
        public void run(){
            settingsPage.setVisible(false);
            changeSettings(settingsPage.getString());
            resetMainPage();
            setDetails(0);
            main.resetCategory();
        }
    }
    
    private class JButtonThread extends Thread {
        private String word;
        
        public JButtonThread(String word){
            this.word = word;
        }
        
        @Override
        public void run(){
            main.setCategory(word);
            setPage(word);
            setDetails(0);
        }
    }
    
    public MainPageController(Version2 main, MainModel model, Settings settings) {
        this.main = main;
        this.model = model;
        this.settingsPage = settings;
        initMainPage();
        settings.setBoxes(model.returnStartList(), model.getLocation());
        setDetails(0);     
    }  
}
