package az.youthacademy.tta.services;

import az.youthacademy.tta.entities.Tours;
import az.youthacademy.tta.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private TourRepository tourRepository;

    @Autowired
    public void setTourRepository(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tours> getAllProducts() {
        return tourRepository.findAll();
    }

    public Tours getProductById(Long id) {
        return tourRepository.findById(id).get();
    }

    public Tours getProductByTitle(String title) {
        return tourRepository.findOneByTitle(title);
    }

    public void deleteProductById(Long id) {
        tourRepository.deleteById(id);
    }
}
