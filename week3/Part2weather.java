import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * 在这里给出对类 Part2weather 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2weather {
    public CSVRecord getColderRecord(CSVRecord row1,CSVRecord row2){
        double temp1 = Double.parseDouble(row1.get("TemperatureF"));
        double temp2 = Double.parseDouble(row2.get("TemperatureF"));
        if(temp2<temp1)
            return row2;
        else
            return row1;
    }
    
    
    public CSVRecord coldestHourInfile(CSVParser parser){
        CSVRecord coldestRow = null;
        for(CSVRecord currRow:parser){
            double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
            if (currTemp==-9999)
                continue;
            else{
                if(coldestRow == null)
                    coldestRow = currRow;
                else
                    coldestRow = getColderRecord(coldestRow,currRow);
            }
        }
        return coldestRow;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInfile(fr.getCSVParser());
        System.out.println("coldest temperature was "+ coldest.get("TemperatureF")
                            +" at "+coldest.get("DateUTC"));
    }
    
    public String fileWithColdestTemperature(){
        String coldestFileName = "";
        CSVRecord coldest = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currRow=coldestHourInfile(fr.getCSVParser());
            if(coldest == null){
                coldest = currRow;
                coldestFileName = f.getName();
            }
            else{
                double temp1 = Double.parseDouble(coldest.get("TemperatureF"));
                double temp2 = Double.parseDouble(currRow.get("TemperatureF"));
                if(temp2<temp1)
                    coldestFileName = f.getName();
            }
        }
        return coldestFileName;
    }
    
    public void testFileWithColdestTemperature(){
        String coldestDay = fileWithColdestTemperature();
        System.out.println("Coldest day was in file "+ coldestDay);
        FileResource fr = new FileResource("C:\\Users\\13720\\Downloads\\nc_weather\\nc_weather\\"+coldestDay.substring(8,12)+"\\"+coldestDay);
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldest = coldestHourInfile(parser);
        System.out.println("Coldest temperature on that day was "+coldest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for(CSVRecord currRow: fr.getCSVParser())
            System.out.println(currRow.get("DateUTC")+":"+currRow.get("TemperatureF"));
        
    }
    
    
}
