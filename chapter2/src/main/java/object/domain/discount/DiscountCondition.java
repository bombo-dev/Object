package object.domain.discount;

import object.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
