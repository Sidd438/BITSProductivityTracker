package tracker.SurajClasses.BITSProductivityTracker;
import java.time.LocalDate;
import BITSProductivityTracker.Student;


public class ProductiveHours {
    private Student student;
    private int productiveHours;
    private LocalDate date = LocalDate.now();

    public ProductiveHours(Student student) {
        this.student = student;
    }

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