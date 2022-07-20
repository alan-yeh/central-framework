package central.util;

import central.lang.Assertx;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * 范围
 * <p>
 * minimum <= range <= maximum
 *
 * @author Alan Yeh
 * @since 2022/07/16
 */
public class Range<T extends Number> implements Serializable {
    @Serial
    private static final long serialVersionUID = 6237219732864605077L;

    /**
     * 区间最小值
     */
    @Getter
    private final T maximum;
    /**
     * 区间最大值
     */
    @Getter
    private final T minimum;

    /**
     * 排序器，用于判断是否在本区音
     */
    @Getter
    private final Comparator<T> comparator;

    /**
     * 构建区间
     */
    public Range(T element1, T element2, Comparator<T> comparator) {
        Assertx.mustTrue(element1 != null && element2 != null, "参数不参为空");

        this.comparator = Objectx.get(comparator, ElementComparator.INSTANCE);

        if (this.comparator.compare(element1, element2) < 1) {
            this.minimum = element1;
            this.maximum = element2;
        } else {
            this.minimum = element2;
            this.maximum = element1;
        }
    }

    /**
     * 构建区间
     */
    public Range(T minimum, T maximum) {
        this(minimum, maximum, ElementComparator.INSTANCE);
    }

    public static <T extends Number> Range<T> of(T minimum, T maximum) {
        return new Range<>(minimum, maximum);
    }

    /**
     * 判断数字是否在本范围内
     *
     * @param element 待判断的数字
     */
    public boolean contains(T element) {
        if (element == null) {
            return false;
        }
        return comparator.compare(element, this.minimum) > -1 && comparator.compare(element, this.maximum) < 1;
    }

    /**
     * 是否包含另一个区间所有的元素
     */
    public boolean containsRange(final Range<T> other) {
        if (other == null) {
            return false;
        }
        return contains(other.getMinimum()) && contains(other.getMaximum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range<?> range = (Range<?>) o;
        return Objects.equals(maximum, range.maximum) &&
                Objects.equals(minimum, range.minimum);
    }

    private transient int hashCode = 0;

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = Objects.hash(maximum, minimum);
        }
        return hashCode;
    }

    private transient String toString;

    @Override
    public String toString() {
        if (toString == null) {
            toString = "[" + minimum + ".." + maximum + "]";
        }
        return toString;
    }

    @SuppressWarnings("rawtypes")
    private enum ElementComparator implements Comparator {
        INSTANCE;

        @Override
        public int compare(Object o1, Object o2) {
            return ((Comparable) o1).compareTo(o2);
        }
    }
}

