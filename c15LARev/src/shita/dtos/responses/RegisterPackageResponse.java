package shita.dtos.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RegisterPackageResponse {
    private String senderDetails;
    private String receiverDetails;
    private LocalDate deliveryDay;
    private boolean payOnDelivery;
}
