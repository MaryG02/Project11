import java.util.Scanner;

class SeriesColl {
    private static Series[] SeriesColl;
    private static int length = 0;
    public int count = 0;


    public static void addSeries(Series series) {
        Series[] arr = new Series[length + 1];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = SeriesColl[i];
        }
        arr[length] = series;
        length++;
        SeriesColl = arr;
    }

    public void SortSeries() {
        boolean isSorted = false;


        while (!isSorted) {
            isSorted = true;

            for (int j = 0; j < length - count - 1; j++) {
                if (SeriesColl[j].Year > SeriesColl[j + 1].Year) {
                    isSorted = false;
                    Series temp = SeriesColl[j];
                    SeriesColl[j] = SeriesColl[j + 1];
                    SeriesColl[j + 1] = temp;
                }

            }
            count++;
        }
    }

    public void printSeries() {
        for (int i = 0; i < length; i++) {
            System.out.println("------------------");
            System.out.println("\nSeries " + (i) + ":");
            SeriesColl[i].getFullDetails();
        }

    }

    public void searchSeriesByTitle(String keyword) {
        for (int i = 0; i < length; i++)
            if (SeriesColl[i].getSeriesName().contains(keyword)) {
                SeriesColl[i].getFullDetails();
            } else System.out.println("There is no more objects including this name");

    }

    public void searchSeriesByYear(int keyword) {
        for (int i = 0; i < length; i++)
            if (keyword == SeriesColl[i].getYear()) {
                SeriesColl[i].getFullDetails();
            }

    }

    public void removeSeries(int index) {
        if(SeriesColl == null||index<0|| index>=SeriesColl.length){
            return ;
        }
        Series[] SeriesCollNew = new Series[SeriesColl.length - 1];
        System.arraycopy(SeriesColl, 0, SeriesCollNew,0, index);
        if (index!= SeriesColl.length-1){
        System.arraycopy(SeriesColl, index+1, SeriesCollNew, index, SeriesColl.length-index-1);
        }
        SeriesColl = SeriesCollNew;
        length--;


    }

    public void printShortList() {
        for (int i = 0; i < length; i++) {
            System.out.println("------------------");
            System.out.println("\nSeries " + (i) + ":");
            SeriesColl[i].getShortDetails();
        }
    }
    public void printOne(int i){
        System.out.println("------------------");
        System.out.println("\nSeries " + (i) + ":");
        SeriesColl[i].getFullDetails();

    }

}
