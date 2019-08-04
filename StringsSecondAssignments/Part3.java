
/**
 * 在这里给出对类 Part3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part3 {

    public int findStopCodon(String dna,int startIndex,String stopCodon){
        int currIndex = dna.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1){
            if((currIndex-startIndex)%3==0)
                return currIndex;
            else{
                currIndex = dna.indexOf(stopCodon,currIndex+1);
        
                }
        }
        return dna.length();
    
    }
    
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1)
            return "";
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = Math.min(Math.min(taaIndex,tagIndex),tgaIndex);
        if (minIndex == dna.length())
            return "";
        else
            return dna.substring(startIndex,minIndex+3);
    }
    
    public void printAllGenes(String dna){
        int startIndex = -1;
        int pos=0;
        String gene = "";
        while(true){
            startIndex = dna.indexOf("ATG",pos);
            if(startIndex != -1){
                gene = findGene(dna.substring(pos));
                System.out.println("gene is"+gene);
                System.out.println(pos);
                pos = startIndex+gene.length();
                
            }
            else
                break;
               
        }
    
    }
    
    public int countGenes(String dna){
        int num = 0;
        int pos = 0;
        
        String gene = "";
        while(true){
            gene = findGene(dna.substring(pos));
            if(gene.isEmpty())
                break;
            else{
                num++;
                pos = dna.indexOf(gene)+gene.length();
            }
            
        }
        return num;
    }
    
    public void testCountGenes(){
        String dna1="ATGTAAATGTGAAA";
        System.out.println(countGenes(dna1));
    }
}
