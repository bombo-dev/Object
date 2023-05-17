package object.chapter1.domain;

import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
public class TicketOffice {
    private Long amount; // 티켓 판매점이 가진 금액
    // 교재에서는 ArrayList 였으나, 티켓 판매 시 0번 인덱스를 지울 때 ArrayList 라면 배열의 이동이 발생하여 LinkedList 로 수정
    private List<Ticket> tickets = new LinkedList<>();

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket() {
        if(tickets.size() == 0) {
            return null;
        }
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
