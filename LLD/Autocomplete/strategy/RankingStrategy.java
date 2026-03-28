
package strategy;

import java.util.*;
import core.*;

public interface RankingStrategy {
    List<Suggestion> rank(List<Suggestion> suggestions);
}