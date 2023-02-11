package ca.sheridancollege.consmatt.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.consmatt.PhoneRepository;
import ca.sheridancollege.consmatt.beans.Phone;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
    
    private PhoneRepository pRepo;
    
    @Override
    public void run(String... args) throws Exception {        
        
        pRepo.deleteAll();
        
        Phone p1 = Phone.builder().title("iphone 6").build();
        Phone p2 = Phone.builder().title("iphone 7").build();
        Phone p3 = Phone.builder().title("iphone 4s").build();

        
        pRepo.save(p1);
        pRepo.save(p2);
        pRepo.save(p3);
        

        
    }
}
