package BITSProductivityTracker;

import java.time.LocalDate;
//for tracking the parameters of the Students
public class Student {
    private String id;
    private String name;
    private double CGPA;
    private double SGPA;
    private int fees;
    private int year;
    private String branchInitial, branchLatter;
    private String BEbranch, Campussy, yearExtract = "", MScbranch;


    //constructor
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getYear() {
        for (int i = 0; i < 3; i++) {
            char c = id.charAt(i);
            yearExtract = yearExtract + c;
        }
        return Integer.valueOf(yearExtract);
    }

       public String getBEbranch() {
            branchInitial = id.substring(4,6);
            branchLatter = id.substring(6,8);
            if (branchLatter.equals("PS")) {
                BEbranch = branchInitial;
                MScbranch = null;
            }
            else {
                BEbranch = branchLatter;
                MScbranch = branchInitial;
            }
            switch (BEbranch){
                case "A1": BEbranch = "Chemical"; break;
                case "A2": BEbranch = "Civil"; break;
                case "A3": BEbranch = "EEE"; break;
                case "A4": BEbranch = "Mechanical"; break;
                case "A5": BEbranch = "Pharma"; break;
                case "A7": BEbranch = "Computer Science"; break;
                case "A8": BEbranch = "ENI"; break;
                case "AB": BEbranch = "Manufacturing"; break;
                case "AA": BEbranch = "ECE"; break;
            }

            return BEbranch;
       }

    public String getMScbranch() {
        branchInitial = id.substring(4,6);
        branchLatter = id.substring(6,8);
        if (branchLatter.equals("PS")) {
            BEbranch = branchInitial;
            MScbranch = null;
        }
        else {
            BEbranch = branchLatter;
            MScbranch = branchInitial;
        }

        switch (MScbranch){
            case "B1" : MScbranch = "Biological Sciences" ; break;
            case "B2" : MScbranch = "Chemistry" ; break;
            case "B3" : MScbranch = "Economics" ; break;
            case "B4" : MScbranch = "Mathematics" ; break;
            case "B5" : MScbranch = "Physics" ; break;
        }
        return MScbranch;
    }

    public String getCampus(){
        char campus = id.charAt((id.length()-1));

        {
            if (campus == 'P' || campus == 'p')
                Campussy = "Pilani";
            if (campus == 'G' || campus == 'g')
                Campussy = "Goa";
            if (campus == 'H' || campus == 'h')
                Campussy = "Hyderabad";
            if (campus == 'D' || campus == 'd')
                Campussy = "Dubai";
        }
        return Campussy;

    }
}


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