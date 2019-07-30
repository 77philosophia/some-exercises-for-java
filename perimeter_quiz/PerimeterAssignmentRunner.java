import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num=0;
        for(Point currPt:s.getPoints()){
            num++;
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double len = getPerimeter(s);
        int num = getNumPoints(s);
        return len/num;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double Largest = 0.0;
        for(Point currPt : s.getPoints()){
            double currLen = prevPt.distance(currPt);
            if(currLen>Largest)
                Largest = currLen;
        }
        return Largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double larX = 0.0;
        for(Point currPt : s.getPoints()){
            if(currPt.getX()>larX)
                larX = currPt.getX();
        }
        return larX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double LarPeMul = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > LarPeMul)
                LarPeMul = getPerimeter(s);
        }
        return LarPeMul;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double LarPeMul = 0.0;
        File temp = null;// replace this code
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > LarPeMul)
                LarPeMul = getPerimeter(s);
                temp = f;
        }
            
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPo = getNumPoints(s);
        System.out.println("number of points = " + numPo);
        double avgLen = getAverageLength(s);
        System.out.println("average length of the shape = "+avgLen);
        double largestLen = getLargestSide(s);
        System.out.println("largest length of the shape = "+largestLen);
        double larX = getLargestX(s);
        System.out.println("Largest X of the shape = "+larX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double LarPeMul = getLargestPerimeterMultipleFiles();
        System.out.println("The Largest Perimeter is = "+ LarPeMul);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName = getFileWithLargestPerimeter();
        System.out.println("the file that has the largest perimeter is "+fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
