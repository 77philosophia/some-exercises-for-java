
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2 {

    public int howMany(String stringa,String stringb){
        int num = 0;
        int index = 0;
        int pos = 0;
        while(true){
            index = stringb.indexOf(stringa,pos);
            if (index==-1)
                break;
            else{
                num++;
                pos = index+stringa.length();
            }
        }
        return num;
    }
    
    public void testHowMany(){
        String string1a = "GAA";
        String string1b = "ATGAACGAATTGAATC";
        int num = howMany(string1a,string1b);
        System.out.println(string1a+"  appears in  "+string1b+" "+num+"times");
    }
}
