package ag.freenet.mealplannerservice.controller;

import ag.freenet.mealplannerservice.service.MealPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/essen")
public class UploadController {

    @Autowired
    private MealPlannerService mealPlannerService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String response = mealPlannerService.handleFileUpload(file);
        return ResponseEntity.ok(response);
    }
}
