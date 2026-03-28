package builder;
import strategy.*;

public class AutocompleteSystemBuilder{
    private RankingStrategy rankingStrategy = new FrequencyBasedRanking();
    private int maxSuggestions = 10;




    // Builder pattern methods for chaining
    public AutocompleteSystemBuilder withRankingStrategy(RankingStrategy rankingStrategy) {
        this.rankingStrategy = rankingStrategy;
        return this;
    }

    public AutocompleteSystemBuilder withMaxSuggestions(int maxSuggestions) {
        this.maxSuggestions = maxSuggestions;
        return this;
    }

    public AutocompleteSystem build() {
        return new AutocompleteSystem(rankingStrategy, maxSuggestions);
    }

}