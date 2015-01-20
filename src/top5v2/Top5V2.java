package top5v2;

import java.awt.EventQueue;


public class Top5V2 {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { 
            @Override 
            public void run() {  
                Version2 view = new Version2();
                MainModel model = new MainModel();
                Settings settings = new Settings(view, true);
                MainPageController controller = new MainPageController(view, model, settings);
                view.setResizable(false);
                view.setVisible(true);
            }
        }); 
    }
}
