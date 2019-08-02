import edu.duke.*;
import java.io.File;
/**
 * 在这里给出对类 Part4 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part4 {
    public String findYoutube(String s){
        String result="";
        int startIndex = s.indexOf("\"");
        int endIndex = s.lastIndexOf("\"");
        result = s.substring(startIndex,endIndex+1);
        return result;
    }
    
    
    public void testing(){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        int youtubeIndex = -1;
        String result="";
        String s_low = "";
        for (String s : ur.words()){
            s_low = s.toLowerCase();
            youtubeIndex = s_low.indexOf("youtube.com");
            if(youtubeIndex!=-1)
                result = findYoutube(s);
                System.out.println(result);
        }
    }
    
}
