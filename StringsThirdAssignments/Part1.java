
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;

public class Part1 {
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
                pos = pos+gene.length();
                
            }
            else
                break;
               
        }
    
    }
    
    public StorageResource getAllGenes(String dna){
        int startIndex = -1;
        int pos =0;
        String gene ="";
        StorageResource geneList = new StorageResource();
        while(true){
            startIndex = dna.indexOf("ATG",pos);
            if(startIndex!=-1){
                gene = findGene(dna.substring(pos));
                geneList.add(gene);
                pos = dna.indexOf(gene)+gene.length();
            }
            else
                break;
        }
        return geneList;
    }
    
    
    public void testFindStopCodon(){
        /**String dna1 = "ATGXYZUVWTAATAGGTA";
        System.out.println("dna1 is"+dna1);
        String result = findGene(dna1);
        System.out.println("result is"+result);
        **/
        String dna2 ="ATGXYZUVWTAATAGGTAATGXYZUVWTAGGTA";
        /**System.out.println("dna2 is"+dna2);
        printAllGenes(dna2);**/
        StorageResource geneList = getAllGenes(dna2);
        for(String s:geneList.data())
            System.out.println(s);
    } 
}
