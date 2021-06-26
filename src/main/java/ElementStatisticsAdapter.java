import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class ElementStatisticsAdapter implements Statistics {

    private final List<Element> elements;

    @Override
    public double getMinValue() {
        return this.elements.stream()
                .map(Element::getValue)
                .min(Comparator.naturalOrder())
                .orElse(0.0);
    }

    @Override
    public double getMaxValue() {
        return this.elements.stream()
                .map(Element::getValue)
                .max(Comparator.naturalOrder())
                .orElse(0.0);
    }

    @Override
    public double getAverage() {
        return this.elements.stream()
                .map(Element::getValue)
                .mapToDouble(d -> (Double) d)
                .average()
                .orElse(0.0);
    }

    @Override
    public int getElementCount() {
        return this.elements.size();
    }

    @Override
    public int getUniqueElementCount() {
        return (int) this.elements.stream().distinct().count();
    }
}
