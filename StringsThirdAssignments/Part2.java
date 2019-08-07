
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2 {
    public float cgRatio(String dna){
        
        int startIndex = 0;
        int sumNum = 0;
        int pos = 0;
        while(true){
            startIndex = Math.min(dna.indexOf("C",pos),dna.indexOf("G",pos));
            if(startIndex!=-1){
                sumNum++;
                pos = startIndex+1;
            }
            else
                break;
        }
    return (float)sumNum/dna.length();
    }
    
    public int countCTG(String dna){
        int startIndex = 0;
        int pos = 0;
        int sumNum = 0;
        while(true){
            startIndex = dna.indexOf("CTG",pos);
            if(startIndex!=-1){
                sumNum++;
                pos = startIndex+3;
            }
            else
                break;
        }
        return sumNum;
    }
    
}
