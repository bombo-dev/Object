package object.chapter1.domain;

import lombok.Data;

@Data
public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    // 티켓을 얻은 경우, 초대권을 잃어야 함.
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;

        if(invitation != null) {
            invitation = null;
        }
    }
}
