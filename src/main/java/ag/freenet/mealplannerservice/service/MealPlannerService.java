package ag.freenet.mealplannerservice.service;

import ag.freenet.mealplannerservice.model.Order;
import ag.freenet.mealplannerservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MealPlannerService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {

        if (order.getOrderId() == null) {
            throw new IllegalArgumentException("OrderId darf nicht leer sein");
        }

        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            System.err.println("Fehler beim Platzieren der Bestellung: " + e.getMessage());
            throw e;
        }
    }

    public String handleFileUpload(MultipartFile file) {

        if (!file.getContentType().equals("image/jpeg")) {
            throw new IllegalArgumentException("Nur JPEG-Bilder sind erlaubt");
        }

        try {
            return "Datei erfolgreich hochgeladen!";
        } catch (Exception e) {
            System.err.println("Fehler beim Hochladen der Datei: " + e.getMessage());
            throw e;
        }
    }
}
