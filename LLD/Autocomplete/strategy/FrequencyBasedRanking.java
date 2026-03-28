package strategy;
import java.util.*;
import java.util.stream.Collectors;
import core.*;


public class FrequencyBasedRanking implements RankingStrategy {
    @Override
    public List<Suggestion> rank(List<Suggestion> suggestions) {
        return suggestions.stream()
                .sorted(Comparator.comparingInt(Suggestion::getWeight).reversed())
                .collect(Collectors.toList());
    }
}