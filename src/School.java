import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class School
{
    Set<Promotion> promotions;

    School(Collection<Promotion> promotions)
    {
        this.promotions = new HashSet<>(promotions);
    }

    /**
     * Find a promotion with the given name.
     * @param promotionName the name of the promotion.
     * @return the promotion if found, {@code null} if not found.
     */
    public Promotion search(String promotionName)
    {
        for (Promotion promotion : promotions)
        {
            if (promotion.getName().equals(promotionName))
            {
                return promotion;
            }
        }
        return null;
    }
}
