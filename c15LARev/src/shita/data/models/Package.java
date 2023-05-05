package shita.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document

public class Package {

    @Id
    private String id;
    private double weight;
    private String senderDetails;
    private String receiverDetails;
    private LocalDateTime timeStamp;
    private List<Event> status;
    private boolean payOnDelivery;


}
