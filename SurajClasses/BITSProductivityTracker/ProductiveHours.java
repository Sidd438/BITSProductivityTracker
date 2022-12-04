package tracker.SurajClasses.BITSProductivityTracker;
import java.time.LocalDate;


public class ProductiveHours {
    private int productiveHours;
    private LocalDate date = LocalDate.now();


    public int getProductiveHours() {
        return productiveHours;
    }

    public void setProductiveHours(int productiveHours) {
        this.productiveHours = productiveHours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}