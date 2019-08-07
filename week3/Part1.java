
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //String info = countryInfo(parser,"Nauru");
        //System.out.println(info);
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser,"fish","nuts");
        //parser = fr.getCSVParser();
        //int number = numberOfExporters(parser,"gold");
        //System.out.println(number);
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser,String country){
        String info = "";
        for(CSVRecord record:parser){
            
            if (record.get("Country").equals(country)){
                
                info = country+":"+record.get("Exports")+":"+record.get("Value (dollars)");
                return info;
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        for(CSVRecord record:parser){
            String ex = record.get("Exports");
            if(ex.contains(exportItem1)&&ex.contains(exportItem2))
                System.out.println(record.get("Country"));
        }
    }
    
    public int numberOfExporters(CSVParser parser,String exportItem){
        int num = 0;
        for(CSVRecord record:parser){
            if(record.get("Exports").contains(exportItem))
                num++;
        }
        return num;
    }
    
    public void bigExporters(CSVParser parser,String amount){
        for(CSVRecord record:parser){
            if(record.get("Value (dollars)").length()>amount.length())
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
        
        }
    
    }
    
}
