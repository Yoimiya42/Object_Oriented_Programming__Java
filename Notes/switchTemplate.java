
package Notes;

public class switchTemplate {
    public static void main(String[] args) {
        
    }
    
    public int getMonthAndDays(String month)
    {
        return getMonthAndDays(month, false);
    }

    public int getMonthAndDays(String month, boolean leapyear)
    {
        var res = switch(month)
        {
            case "January", "March", "May", "July", "August", "October", "December" -> 31;
            case "April", "June", "September", "November" -> 30;
            case "February" ->
            {
                if(leapyear) {yield 29;}
                else {yield 28;}
            }
            default -> 0;
        };

        return res;

    }
}

