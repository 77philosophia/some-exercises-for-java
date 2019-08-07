import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * 在这里给出对类 Part3Humidity 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part3Humidity {
    public CSVRecord getLowestRecord(CSVRecord row1,CSVRecord row2){
        double humi1 = Double.parseDouble(row1.get("Humidity"));
        double humi2 = Double.parseDouble(row2.get("Humidity"));
        if(humi2<humi1)
            return row2;
        else
            return row1;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestRow = null;
        for(CSVRecord currRow:parser){
            if(currRow.get("Humidity").equals("N/A"))
                continue;
            else{
                if(lowestRow==null)
                    lowestRow = currRow;
                else
                    lowestRow = getLowestRecord(lowestRow,currRow);
            }
        }
        return lowestRow;
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestRow = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currRow=lowestHumidityInFile(fr.getCSVParser());
            if(lowestRow == null)
                lowestRow = currRow;
            else
                lowestRow = getLowestRecord(lowestRow,currRow);
            
        }
        return lowestRow;
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
}
