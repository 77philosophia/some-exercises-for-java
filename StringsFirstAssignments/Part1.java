
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {
    public String findSimpleGene(String s){
        String dna ="";
        int startIndex = s.indexOf("ATG");
        if(startIndex == -1)
            return "";
        int endIndex = s.indexOf("TAA",startIndex+3);
        if(endIndex == -1)
            return "";
        if ((endIndex-startIndex)%3 != 0)
            return "";
        dna = s.substring(startIndex,endIndex+3);
    
        return dna;
    }
    
    public void testSimpleGene(){
        String dna1 = "ATGAAATAA";
        System.out.println("dna1 ="+dna1);
        String resultDNA1 = findSimpleGene(dna1);
        System.out.println("the result of dna1 is "+resultDNA1);
    
    
    }

}
