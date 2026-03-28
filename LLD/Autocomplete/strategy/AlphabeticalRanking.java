
package strategy;

import java.util.*;
import java.util.stream.Collectors;
import core.Suggestion;

public class AlphabeticalRanking implements RankingStrategy {
    @Override
    public List<Suggestion> rank(List<Suggestion> suggestions) {
        return suggestions.stream()
                .sorted(Comparator.comparing(Suggestion::getWord))
                .collect(Collectors.toList());
    }
}