
import java.util.ArrayList;

public class Conversion {
    public static void main(String[] args) {
        FromCelsiusToFahrenheit conversion = new FromCelsiusToFahrenheit(0, 40);
        conversion.setHeader("Temperature Conversion Table");
        conversion.setColumnHeader("C", "F");
        conversion.setSpaces(6);
        conversion.setColumns(5);
        conversion.generateTable();

        ArrayList<ArrayList<String>> table = conversion.copyOfTable();
        for(ArrayList<String> row : table)
        {
            for(String cell : row)
            {
                System.out.print(cell);
            }
        }
    }
}

class FromCelsiusToFahrenheit{
    private final int upper;
    private final int lower;
    private ArrayList<ArrayList <String>> formattedTable;

    private String tableHeader;
    private String columnHeaderC;
    private String columnHeaderF;
    private int columns;
    private int spaces;

    public FromCelsiusToFahrenheit(int lower, int upper){
        this.lower = lower;
        this.upper = upper;
    }

    public void setHeader(String tableHeader)
    {
        this.tableHeader = tableHeader;
    }

    public void setColumnHeader(String columnHeaderC, String columnHeaderF){
        this.columnHeaderC = columnHeaderC;
        this.columnHeaderF = columnHeaderF;
    }

    public void setSpaces(int spaces)
    {
        this.spaces = spaces;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    private double convertCelsiusToFahrenheit(double celsius)
    {
        return celsius * 1.8 + 32;
    }

    public void generateTable(){
        formattedTable = new ArrayList<>();
        ArrayList<String> TableHeader = new ArrayList<>();

        ArrayList<String> columnHeader = new ArrayList<>();
        String columnHeaderCell = String.format("%-" + spaces + "s%-" + (int)(spaces * 1.5) + "s", 
                                                columnHeaderC, columnHeaderF);
                                                
        String columnHeaderLine = columnHeaderCell.repeat(columns) + "\n";
        int lineLength = columnHeaderLine.length();
        columnHeader.add(columnHeaderLine); 

        TableHeader.add(" ".repeat((lineLength - tableHeader.length()) / 2) + tableHeader);
        TableHeader.add("\n" + "-".repeat(lineLength) + "\n");
        
        formattedTable.add(TableHeader);
        formattedTable.add(columnHeader);    

        int count = lower;
        while (count <= upper) 
        {
            ArrayList<String> row = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < columns && count + i <= upper; i++) 
            {
                sb.append(String.format("%-" + spaces + "d%-" + (int)(spaces * 1.5) + ".1f", 
                                        count + i, convertCelsiusToFahrenheit(count + i)
                                        ));
            }
            sb.append("\n");
            row.add(sb.toString());
            formattedTable.add(row);
            count += columns;
        }
        
        
    }

    public ArrayList<ArrayList<String>> copyOfTable(){
        ArrayList<ArrayList<String>> copy = new ArrayList<>();
        for (ArrayList<String> row : formattedTable) {
            copy.add(new ArrayList<>(row));
        }
        return copy;
    }
}

