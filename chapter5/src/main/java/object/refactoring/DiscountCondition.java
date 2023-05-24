package object.refactoring;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
