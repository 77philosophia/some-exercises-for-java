
/**
 * 在这里给出对类 Part3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part3 {
    public boolean twoOccurrencs(String stringa,String stringb){
        
        int oneIndex = stringb.indexOf(stringa);
        if (oneIndex == -1)
            return false;
        else{
            if (stringb.indexOf(stringa,oneIndex+stringa.length())==-1)
                return false;
            else
                return true;
        }
        
    }
    
    public String lastPart(String stringa,String stringb){
        int index = stringb.indexOf(stringa);
        if (index == -1)
            return stringb;
        else{
            return stringb.substring(index+stringa.length());
        }
    
    }
    
    public void testing(){
        String a1 = "by";
        String b1 = "A story by Abby Long";
        boolean jud1 = twoOccurrencs(a1,b1);
        System.out.println("stringa="+a1);
        System.out.println("stringb="+b1);
        System.out.println("results="+jud1);
        String a2 = "an";
        String b2 = "banana";
        String result2 = lastPart(a2,b2);
        String a3 = "zoo";
        String b3 = "forest";
        String result3 = lastPart(a3,b3);
        System.out.print("stringa="+a2);
        System.out.print("stringb="+b2);
        System.out.println("results2="+result2);
        System.out.println("results3="+result3);
    }
}
