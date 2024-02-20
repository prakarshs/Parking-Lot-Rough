package org.LLD.Helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Services.Display.DisplayService;
import org.LLD.Services.Display.DisplayServiceIMPL;
import org.LLD.Services.Find.FindingService;
import org.LLD.Services.Find.FindingServiceIMPL;
import org.LLD.Services.Ticket.TicketService;
import org.LLD.Services.Ticket.TicketServiceIMPL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutowireService {
    DisplayService displayService = new DisplayServiceIMPL();
    FindingService findingService = new FindingServiceIMPL();
    TicketService ticketService = new TicketServiceIMPL();
}
