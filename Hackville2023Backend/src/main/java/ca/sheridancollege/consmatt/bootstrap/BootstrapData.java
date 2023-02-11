package ca.sheridancollege.consmatt.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.consmatt.beans.Donator;
import ca.sheridancollege.consmatt.beans.Receiver;
import ca.sheridancollege.consmatt.repositories.DonatorRepository;
import ca.sheridancollege.consmatt.repositories.ReceiveRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
    
    private DonatorRepository dRepo;
    private ReceiveRepository rRepo;

    
    @Override
    public void run(String... args) throws Exception {        
        
        dRepo.deleteAll();
        rRepo.deleteAll();
        
        Donator d1 = Donator.builder().title("iphone 6").category("Phones").description("Brand new").damage("No damage").address("24 Manoir drive, Ottawa, Ontario, K0A 1W0").name("Jim Buhler").phoneNumber("6134431216").email("jimmyjim@gmail.com").imageLink("https://appletradein.likewize.com/Phonemodel/9182_30_150.jpg").build();
        Donator d2 = Donator.builder().title("iphone 6").category("Phones").description("Brand new").damage("No damage").address("24 Manoir drive, Ottawa, Ontario, K0A 1W0").name("Jim Buhler").phoneNumber("6134431216").email("jimmyjim@gmail.com").build();
        Donator d3 = Donator.builder().title("iphone 6").category("Phones").description("Brand new").damage("No damage").address("24 Manoir drive, Ottawa, Ontario, K0A 1W0").name("Jim Buhler").phoneNumber("6134431216").email("jimmyjim@gmail.com").build();

        
        dRepo.save(d1);
        dRepo.save(d2);
        dRepo.save(d3);
        
        Receiver r1 = Receiver.builder().phoneRequested("iphone 6").name("Hairy Henry").phoneNumber("1234567891").address("16 kimber drive, Ottawa, Ontario, K0A 1W0").build();
        
        rRepo.save(r1);

        

        
    }
}
