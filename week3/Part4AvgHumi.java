import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * 在这里给出对类 Part4AvgHumi 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part4AvgHumi {
    public double averageTemperatureInFile(CSVParser parser){
        double sumTemp = 0.0;
        int sumNum = 0;
        double currTemp =0.0;
        for(CSVRecord currRow:parser){
            currTemp = Double.parseDouble(currRow.get("TemperatureF"));
            if(currTemp==-9999)
                continue;
            else{
                sumNum++;
                sumTemp += currTemp;
            }
        }
        return sumTemp/sumNum;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        double avg = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is "+avg);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
        int sumNum = 0;
        double sumTemp = 0.0;
        double currHumi = 0.0;
        for(CSVRecord currRow:parser){
            if(currRow.get("Humidity").equals("N/A"))
                continue;
            else{
                currHumi = Double.parseDouble(currRow.get("Humidity"));
                if(currHumi>=value){
                    sumNum++;
                    sumTemp+=Double.parseDouble(currRow.get("TemperatureF"));
                }   
            }
        }
        if(sumNum!=0)
            return sumTemp/sumNum;
        else
            return -9999.0;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        double avgTemp = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
        if(avgTemp==-9999.0)
            System.out.println("No temperatures with that humidity");
        else
            System.out.println("Average Temp when high Humidity is "+avgTemp);
    } 
}
