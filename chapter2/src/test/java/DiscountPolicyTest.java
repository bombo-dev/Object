import object.domain.Money;
import object.domain.Movie;
import object.domain.Screening;
import object.domain.discount.AmountDiscountPolicy;
import object.domain.discount.PercentDiscountPolicy;
import object.domain.discount.PeriodCondition;
import object.domain.discount.SequenceCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DiscountPolicyTest {

    Movie avatar;
    Movie titanic;

    @BeforeEach
    void movieListInit() {
        avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));
    }

    @Test
    @DisplayName("고정 금액 할인 테스트")
    void amountDiscountPolicy() {
        //given
        Screening avatarScreening = new Screening(avatar, 0, LocalDateTime.of(2023, 5, 18, 10, 1, 0));
        Money money = avatar.calculateMovieFee(avatarScreening);
        Assertions.assertEquals(9200, money.getAmount().intValue());
    }
}
