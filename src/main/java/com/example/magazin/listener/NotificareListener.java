package com.example.magazin.listener;

import com.example.magazin.event.StareSchimbataEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificareListener {

    @EventListener
    public void trimiteNotificare(StareSchimbataEvent event) {
        var comanda = event.getComanda();

        System.out.println(">>> [OBSERVER SPRING] Email trimis către clientul: "
                + comanda.getClient().getEmail());
        System.out.println("    Subiect: Comanda " + comanda.getId()
                + " și-a schimbat starea în " + comanda.getStare());
    }

    @EventListener
    public void logAudit(StareSchimbataEvent event) {
        System.out.println(">>> [AUDIT] Logare în baza de date pentru comanda "
                + event.getComanda().getId());
    }
}
