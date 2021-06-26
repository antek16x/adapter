import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Element> elements = List.of(
                new Element(548.0, Type.TYPE_1),
                new Element(546.45, Type.TYPE_1),
                new Element(546.45, Type.TYPE_1),
                new Element(4788.45, Type.TYPE_2),
                new Element(0.45, Type.TYPE_2),
                new Element(546.45, Type.TYPE_1),
                new Element(546.45, Type.TYPE_1),
                new Element(459.0, Type.TYPE_2),
                new Element(784.45, Type.TYPE_1),
                new Element(485.69, Type.TYPE_2),
                new Element(485.69, Type.TYPE_1));


        StatisticsPrinter statisticsPrinter = new StatisticsPrinter();

        System.out.println("Statistics for all elements: ");
        statisticsPrinter.print(createAdapter(elements));
        System.out.println("Statistics for elements where type is TYPE_1: ");
        statisticsPrinter.print(createAdapter(elements, Type.TYPE_1));
        System.out.println("Statistics for elements where type is TYPE_2: ");
        statisticsPrinter.print(createAdapter(elements, Type.TYPE_2));

    }

    private static ElementStatisticsAdapter createAdapter(List<Element> elements) {
        return new ElementStatisticsAdapter(elements);
    }

    private static ElementStatisticsAdapter createAdapter(Collection<Element> elements, Type type) {
        return new ElementStatisticsAdapter(getElements(elements, element -> element.getType() == type));
    }

    public static List<Element> getElements(Collection<Element> elements, Predicate<Element> predicate) {
        return elements
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
