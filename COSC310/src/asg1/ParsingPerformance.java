package asg1;

import java.util.ArrayList;

public class ParsingPerformance {

    // Instance variables the two data structures we will be comparing in this assignment
    // the first data structures is a 2D array where rows are different records and column[0] is front chainring teeth, column[1] is rear cog teeth
    // the second is an ArrayList of int arrays where each int array has two elements: front chainring teeth and rear cog teeth
    protected int[][] array;
    protected ArrayList<int[]> list;

    public static void main(String[] args) {
       //Download the contents of this URL into a String: "https://raw.githubusercontent.com/kartoone/cosc310/refs/heads/main/data/recorddata.txt"
       // Parse the String into an array of Strings by splitting the String using "\n" as the regular expression (e.g., testData.split("\n") ) 
       ParsingPerformance parsingPerformance = new ParsingPerformance();
       String data = URLContentDownloader.downloadUrlContent("https://raw.githubusercontent.com/kartoone/cosc310/refs/heads/main/data/recorddata.txt");
       parsingPerformance.parseData(data);
       long arrayTime = parsingPerformance.calculateStatsArray();
       long listTime = parsingPerformance.calculateStatsList();
       System.out.println("Array time: " + arrayTime + " ns");
       System.out.println("List time: " + listTime + " ns");
    }
    
    public void parseData(String data) {
        String[] records = data.split("\n");
        array = new int[records.length][2];
        list = new ArrayList<int[]>();
        for (int i = 0; i < records.length; i++) {
            String[] fields = records[i].split(" ");
            String[] gearfield = fields[10].split(",");
            String[] subgearfields = gearfield[0].split("x");
            array[i][0] = Integer.parseInt(subgearfields[0]);
            array[i][1] = Integer.parseInt(subgearfields[1]);
            list.add(new int[] {Integer.parseInt(subgearfields[0]), Integer.parseInt(subgearfields[1])});
        }
        for (int[] gears : array)
            System.out.println(java.util.Arrays.toString(gears));
        System.out.println("Press any key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignored
        }
        for (int[] gears : list)
            System.out.println(java.util.Arrays.toString(gears));
    }

    protected long calculateStatsArray() {
        long start =  System.nanoTime();
        int frontTotal = 0;
        int rearTotal = 0;
        int frontMin = array[0][0];
        int rearMin = array[0][1];
        int frontMax = array[0][0];
        int rearMax = array[0][1];

        for(int i = 0; i<array.length; i++) {
            frontTotal += array[i][0];
            rearTotal += array[i][1];
            if(frontMin > array[i][0]) {
                frontMin = array[i][0];
            }
            if(rearMin > array[i][1]) {
                rearMin = array[i][1];
            }
            if(frontMax < array[i][0]) {
                frontMax = array[i][0];
            }
            if(rearMax < array[i][1]) {
                rearMax = array[i][1];
            }
        }
        long end = System.nanoTime();

        System.out.println("Front");
        System.out.println("Minimum: "+frontMin + " Maximum: "+frontMax + " Average: "+frontTotal/array.length);
        System.out.println("Rear");
        System.out.println("Minimum: "+rearMin + " Maximum: "+rearMax + " Average: "+rearTotal/array.length);

        return end - start;
    }
    protected long calculateStatsList() {
        long start =  System.nanoTime();
        int frontTotal = 0;
        int rearTotal = 0;
        int frontMin = list.get(0)[0];
        int rearMin = list.get(0)[1];
        int frontMax = list.get(0)[0];
        int rearMax = list.get(0)[1];
        
        for(int i = 0; i<list.size(); i++) {
            frontTotal += list.get(i)[0];
            rearTotal += list.get(i)[1];
            if(frontMin > list.get(i)[0]) {
                frontMin = list.get(i)[0];
            }
            if(rearMin > list.get(i)[1]) {
                rearMin = list.get(i)[1];
            }
            if(frontMax < list.get(i)[0]) {
                frontMax = list.get(i)[0];
            }
            if(rearMax < list.get(i)[1]) {
                rearMax = list.get(i)[1];
            }
        }
        long end = System.nanoTime();
        
        System.out.println("Front");
        System.out.println("Minimum: "+frontMin + " Maximum: "+frontMax + " Average: "+frontTotal/array.length);
        System.out.println("Rear");
        System.out.println("Minimum: "+rearMin + " Maximum: "+rearMax + " Average: "+rearTotal/array.length);

        return end - start;
    }
}