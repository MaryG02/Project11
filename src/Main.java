import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        System.out.println("Hello, welcome to series collection!");
        while (menu) {
            System.out.println("-----------Menu-------------");
            System.out.println("Choose an option:\n" +
                    "1 - Add series to collection\n" +
                    "2 - Print all series with detailed description\n" +
                    "3 - Sort series by year\n" +
                    "4 - Search series by title\n" +
                    "5 - Search series by year\n" +
                    "6 - remove series\n" +
                    "7 - Print the list of series with short description\n" +
                    "8 - Print full details for particular series\n"+
                    "0 - exit program");
            input = scan.nextLine();
            SeriesColl collection = new SeriesColl();
            if (Objects.equals(input, "1")) {
                AddingSeries();
            }
            if (Objects.equals(input, "2")) {
                collection.printSeries();

            }
            if (Objects.equals(input, "3")) {
                System.out.println("Sorting series by year");
                collection.SortSeries();
                collection.printSeries();

            }
            if (Objects.equals(input, "4")) {
                System.out.println("Enter the keyword to search");
                String keyword;
                keyword = scan.nextLine();
                collection.searchSeriesByTitle(keyword);

            }
            if (Objects.equals(input, "5")) {
                System.out.println("Enter the the year to search");
                int year;
                year = scan.nextInt();
                collection.searchSeriesByYear(year);

            }
            if (Objects.equals(input, "6")){
                System.out.println("Enter number of the series you want to delete");
                int index = scan.nextInt();
                collection.removeSeries(index);
                System.out.println("The series was successfully deleted ");

            }
            if (Objects.equals(input, "7")){
                collection.printShortList();

            }
            if (Objects.equals(input, "8")){
                System.out.println("Please, enter the number of the added series");
                int i = scan.nextInt();
                collection.printOne(i);

            }
            if (Objects.equals(input, "0")) {
                menu = false;
                System.exit(0);

            }

        }
    }
    private static void AddingSeries() {
        Scanner scan = new Scanner(System.in);
        boolean isAdding = true;
        while (isAdding) {
            System.out.println("To add a series, enter the title:");
            String seriesName = scan.nextLine();
            System.out.println("Status(Finished/To be continued)");
            String IsFinished = scan.nextLine();
            System.out.println("Number of seasons:");
            int NumberOfSeasons = scan.nextInt();
            System.out.println("Year of airing:");
            int Year = scan.nextInt();
            scan.nextLine();
            Series series = new Series(seriesName,NumberOfSeasons, IsFinished, Year);
            SeriesColl.addSeries(series);
            System.out.println("Do you want to add a new series, Y/N");
            String answer = scan.nextLine();
            if (answer.toLowerCase().equals("y"))
                isAdding = true;
            else {
                isAdding = false;
            }
        }
    }
}