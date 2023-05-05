package shita.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterPackageRequest {
    private double weight;
    private String senderName;
    private String senderAddress;
    private String senderPhoneNumber;
    private String receiverName;
    private String receiverAddress;
    private String receiverPhoneNumber;
    private LocalDateTime timeStamp;
    private boolean payOnDelivery;
}
