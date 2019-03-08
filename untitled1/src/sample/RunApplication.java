package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.model.DataModel;
import sample.model.Model;
import sample.view.MainView;
import sample.viewmodel.ViewModelProvider;

import java.util.Random;

public class RunApplication extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(RunApplication.class);
        System.out.println("A ");
    }
    @Override
    public void start(Stage stage) throws Exception {
        Model m = new DataModel();
        ViewModelProvider mvvm = new ViewModelProvider(m);
        MainView mv = new MainView(stage, mvvm);
        mv.start();
        runAutoUpdate((DataModel) m);
    }
    private void runAutoUpdate(DataModel m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(500) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

}

