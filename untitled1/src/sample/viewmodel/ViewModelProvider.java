package sample.viewmodel;

import sample.model.Model;
import sample.viewmodel.piechart.PieChartViewModel;

public class ViewModelProvider {

    private Model model;

    private PieChartViewModel pieChartViewModel;

    public ViewModelProvider(Model model) {
        this.model = model;
        pieChartViewModel = new PieChartViewModel(model);
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }
}
