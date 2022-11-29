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
        int nPts = 0;
        for (Point nTms : s.getPoints()) {
            nPts = nPts + 1;
        }
        return nPts;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double Avg = 0.0;
        double sides = 0.0;
        double sum = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            sides = sides + 1;
            double currDist = prevPt.distance(currPt);
            sum = sum + currDist;
            prevPt = currPt;
        }
        Avg = sum / sides;
        return Avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double side = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > side) {
                side = currDist;
                prevPt = currPt;
            }
            else {
                prevPt = currPt;
            }
        }
        return side;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double lrgst = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            int x = currPt.getX();
            if (x > lrgst) {
                lrgst = x;
                prevPt = currPt;
            }
            else {
                prevPt = currPt;
            }
        }
        return lrgst;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        Shape s;
        double maxPer = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            s = new Shape(fr);
            double justPer = 0.0;
            Point prevPt = s.getLastPoint();
            for (Point currPt : s.getPoints()) {
                double currDist = prevPt.distance(currPt);
                justPer = justPer + currDist;
                prevPt = currPt;
            }
            if (justPer > maxPer){
                maxPer = justPer;
            }
        }
        return maxPer;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    
        double largestPer = 0.0;
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPer){
                largestPer = getPerimeter(s);
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numP = getNumPoints(s);
        System.out.println("number of points = " + numP);
        double Avg = getAverageLength(s);
        System.out.println("length average = " + Avg);
        double largest = getLargestSide(s);
        System.out.println("largest side = " + largest);
        double largestX = getLargestX(s);
        System.out.println("largest X component = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double maxper = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + maxper);
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name = getFileWithLargestPerimeter();
        System.out.println("largest file = " + name);
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
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
