public class StatisticsPrinter {

    public void print(Statistics statistics) {
        System.out.println(String.format(
                "Average: %f, \n " +
                        "Max value: %f, \n " +
                        "Min value: %f, \n" +
                        "Element count: %d, \n " +
                        "Unique element count: %d. \n",
                statistics.getAverage(),
                statistics.getMaxValue(),
                statistics.getMinValue(),
                statistics.getElementCount(),
                statistics.getUniqueElementCount()));
    }
}
