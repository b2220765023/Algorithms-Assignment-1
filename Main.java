
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        double[][] averageTimesRandom = new double[3][10];
        double[][] averageTimesSorted = new double[3][10];
        double[][] averageTimesReversalySorted = new double[3][10];
        double[][] averageTimesRandomSearches = new double[3][10];

        Random random = new Random();
        // X axis data
        int[] inputAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};
        // Create sample data for linear runtime
        double[][] yAxis = new double[2][10];
        yAxis[0] = new double[]{512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};
        yAxis[1] = new double[]{300, 800, 1800, 3000, 7000, 15000, 31000, 64000, 121000, 231000};


        int[] data = FileReading.getData("TrafficFlowDataset.csv");

        int[] sizes = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};
        int[][] arrays = new int[sizes.length][];

        for (int j = 0; j < sizes.length; j++) {
            arrays[j] = new int[sizes[j]];
            for (int i = 0; i < sizes[j]; i++) {
                arrays[j][i] = data[i];
            }
        }

        for (int i = 0; i < sizes.length; ++i){
            List <Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int max = Arrays.stream(arrays[i]).max().getAsInt();
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.CountingSort(copyArray,max);
                Long time2 = System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);

            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);

            }
            double average = (double) total / durations.size();
            averageTimesRandom[0][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Counting Sort is: " + average + " ms.");
        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();

        for (int i = 0; i < sizes.length; ++i){
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.InsertionSort(copyArray);
                Long time2 =  System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);

            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
                //averageTimes[1][k] = durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesRandom[1][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Insertion Sort is: " + average+ " ms.");
        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();
        for (int i = 0; i < sizes.length; ++i){
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.MergeSort(copyArray);
                Long time2 = System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);

            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesRandom[2][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Merge Sort is: " + average + " ms.");
        }


        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();



        for (int i = 0; i < sizes.length; ++i){
            Sorts.MergeSort(arrays[i]);
            List <Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int max = Arrays.stream(arrays[i]).max().getAsInt();
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.CountingSort(copyArray,max);
                Long time2 = System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);


            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);

            }
            double average = (double) total / durations.size();
            averageTimesSorted[0][i] = average;
            System.out.println("Running Time of size "+sizes[i]+"  in Counting Sort with SORTED input is: " + average + " ms.");

        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();

        for (int i = 0; i < sizes.length; ++i){
            Sorts.MergeSort(arrays[i]);
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.InsertionSort(copyArray);
                Long time2 =  System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);

            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesSorted[1][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Insertion Sort with SORTED input is: " + average+ " ms.");
        }
        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();
        for (int i = 0; i < sizes.length; ++i){
            Sorts.MergeSort(arrays[i]);
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.MergeSort(copyArray);
                Long time2 = System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);

            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesSorted[2][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Merge Sort with SORTED input is: " + average + " ms.");
        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();
        reverseSort2DArray(arrays,sizes,data);

        for (int i = 0; i < sizes.length; ++i){
            List <Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int max = Arrays.stream(arrays[i]).max().getAsInt();
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.CountingSort(copyArray,max);
                Long time2 = System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);


            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);

            }
            double average = (double) total / durations.size();
            averageTimesReversalySorted[0][i] = average;
            System.out.println("Running Time of size "+sizes[i]+"  in Counting Sort with REVERSALY SORTED input is: " + average + " ms.");

        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();

        for (int i = 0; i < sizes.length; ++i){
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.InsertionSort(copyArray);
                Long time2 =  System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);

            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
                //averageTimes[1][k] = durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesReversalySorted[1][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Insertion Sort with REVERSALY SORTED input is: " + average+ " ms.");
        }
        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();
        for (int i = 0; i < sizes.length; ++i){
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 10; ++j){
                int[] copyArray = arrays[i].clone();
                Long time1 = System.currentTimeMillis();
                Sorts.MergeSort(copyArray);
                Long time2 = System.currentTimeMillis();

                Long duration = time2-time1;
                durations.add(duration);

            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesReversalySorted[2][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Merge Sort with REVERSALY SORTED input is: " + average + " ms.");
        }

        for (int j = 0; j < sizes.length; j++) {
            arrays[j] = new int[sizes[j]];
            for (int i = 0; i < sizes[j]; i++) {
                arrays[j][i] = data[i];
            }
        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();

        for (int i = 0; i < sizes.length; ++i){
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 1000; ++j) {
                int[] copyArray = arrays[i].clone();
                int randomIndex = random.nextInt(copyArray.length); // Generate random index
                int randomValue = copyArray[randomIndex];
                Long time1 = System.nanoTime();
                Searches.LinearSearch(copyArray, randomValue);
                Long time2 = System.nanoTime();

                Long duration = time2 - time1;
                durations.add(duration);
            }
                long total = 0;
                for(int k= 0; k < durations.size(); k++){
                    total += durations.get(k);
                }
                double average = (double) total / durations.size();
                averageTimesRandomSearches[0][i] = average;
                System.out.println("Running Time of size "+sizes[i]+" in Linear Search with RANDOM input is: " + average + " ns.");

        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();

        for (int i = 0; i < sizes.length; ++i){
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 1000; ++j) {
                int[] copyArray = arrays[i].clone();
                int randomIndex = random.nextInt(copyArray.length); // Generate random index
                int randomValue = copyArray[randomIndex];
                Long time1 = System.nanoTime();
                Searches.LinearSearch(copyArray, randomValue);
                Long time2 = System.nanoTime();

                Long duration = time2 - time1;
                durations.add(duration);
            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesRandomSearches[1][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Linear Search with SORTED input is: " + average + " ns.");

        }

        System.out.println();
        System.out.println("*************************************************************************************");
        System.out.println();

        for (int i = 0; i < sizes.length; ++i){
            Sorts.MergeSort(arrays[i]);
            List<Long> durations = new ArrayList<>();
            for(int j = 0; j< 1000; ++j) {
                int[] copyArray = arrays[i].clone();
                int randomIndex = random.nextInt(copyArray.length); // Generate random index
                int randomValue = copyArray[randomIndex];
                Long time1 = System.nanoTime();
                Searches.BinarySearch(copyArray, randomValue);
                Long time2 = System.nanoTime();

                Long duration = time2 - time1;
                durations.add(duration);
            }
            long total = 0;
            for(int k= 0; k < durations.size(); k++){
                total += durations.get(k);
            }
            double average = (double) total / durations.size();
            averageTimesRandomSearches[2][i] = average;
            System.out.println("Running Time of size "+sizes[i]+" in Binary Search with SORTED input is: " + average + " ns.");

        }

        // Save the char as .png and show it
        showAndSaveChart("Test For Random Data", inputAxis, averageTimesRandom);
        showAndSaveChart("Test For Sorted Data", inputAxis, averageTimesSorted);
        showAndSaveChart("Test For Reversaly Sorted Data", inputAxis, averageTimesReversalySorted);
        showAndSaveChart("Test For Search Data", inputAxis, averageTimesRandomSearches);

    }

    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("Linear Search Random Input", doubleX, yAxis[0]);
        chart.addSeries("Linear Search Sorted Input", doubleX, yAxis[1]);
        chart.addSeries("Binary Search Sorted Input", doubleX, yAxis[2]);


        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }



    public static void reverseSort2DArray(int[][] arrays, int[] sizes, int[] data) {
        for (int j = 0; j < sizes.length; j++) {
            arrays[j] = new int[sizes[j]];
            for (int i = 0; i < sizes[j]; i++) {
                arrays[j][i] = data[i];
            }
            Integer[] boxedArray = Arrays.stream(arrays[j]).boxed().toArray(Integer[]::new);
            Arrays.sort(boxedArray, Comparator.reverseOrder());
            for (int i = 0; i < sizes[j]; i++) {
                arrays[j][i] = boxedArray[i];
            }
        }
    }
}
