package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.piechart.PieChartView;
import sample.viewmodel.ViewModelProvider;

import java.io.IOException;

public class MainView {
    private Stage stage;
    private ViewModelProvider mvViewModel;
    public MainView(Stage stage, ViewModelProvider mvViewModel) {
        this.stage = stage;

    this.mvViewModel = mvViewModel;
}    public void start() throws Exception{
    openView("PieChart");
}    public void openView(String viewToOpen) throws IOException {
    Scene scene = null;        FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    if("PieChart".equals(viewToOpen)) {
        loader.setLocation(getClass().getResource("piechart/PieChart.fxml"));
        root = loader.load();
        PieChartView view = loader.getController();
        view.init(mvViewModel.getPieChartViewModel());
        stage.setTitle("Pie Chart");
    }
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
}
