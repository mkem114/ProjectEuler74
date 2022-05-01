import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.isNull;

public class Main {

    private static final int[] DIGIT_FACTORIALS = {1, 1, 2, 6, 24, 120, 720, 5_040, 40_320, 362_880, 3_628_800};
    private static final int DESIRED_CHAIN_LENGTH = 60;
    private static final int ONE_MILLION = 1_000_000;
    private static final Map<Integer, Integer> edges = new HashMap<>();

    public static void main(String[] args) {
        int count = getCount(ONE_MILLION);
        System.out.println(count);
    }

    static int getCount(final int limit) {
        int count = 0;
        for (int i = 0; i < limit; i++) {
            if (recurse(new HashSet<>(), i).size() == DESIRED_CHAIN_LENGTH) {
                count++;
            }
        }
        return count;
    }

    private static Set<Integer> recurse(final Set<Integer> seen, final int node) {
        if (seen.contains(node)) {
            return seen;
        }

        seen.add(node);
        return recurse(seen, getNext(node));
    }

    private static Integer getNext(final int from) {
        Integer to = edges.get(from);
        if (isNull(to)) {
            to = String.valueOf(from)
                    .chars()
                    .map(Character::getNumericValue)
                    .map(digit -> DIGIT_FACTORIALS[digit])
                    .sum();
            edges.put(from, to);
        }
        return to;
    }
}
