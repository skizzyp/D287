package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //determine if database already contains information
        if (inhousePartRepository.count() == 0) {


            //setting values for in house parts if database is empty
            InhousePart wheel = new InhousePart();
            wheel.setId(14);
            wheel.setName("Wheel");
            wheel.setPrice(5.00);
            wheel.setInv(86);
            wheel.setMax(100);
            wheel.setMin(1);

            inhousePartRepository.save(wheel);

            InhousePart battery = new InhousePart();
            battery.setId(10);
            battery.setName("Battery");
            battery.setPrice(10.00);
            battery.setInv(90);
            battery.setMax(100);
            battery.setMin(1);

            inhousePartRepository.save(battery);
        }

        //same process for outsourced parts
        if (outsourcedPartRepository.count() == 0) {
            OutsourcedPart controller = new OutsourcedPart();
            controller.setId(7);
            controller.setName("Controller");
            controller.setPrice(50.00);
            controller.setInv(99);
            controller.setMax(100);
            controller.setMin(1);

            outsourcedPartRepository.save(controller);


            OutsourcedPart motor = new OutsourcedPart();
            motor.setId(8);
            motor.setName("Motor");
            motor.setPrice(35.00);
            motor.setInv(99);
            motor.setMax(100);
            motor.setMin(1);

            outsourcedPartRepository.save(motor);

            OutsourcedPart wires = new OutsourcedPart();
            wires.setId(9);
            wires.setName("Wires");
            wires.setPrice(5.00);
            wires.setInv(50);
            wires.setMax(100);
            wires.setMin(1);

            outsourcedPartRepository.save(wires);
        }

        if (productRepository.count() == 0) {
            // create products
            Product Drone = new Product("Drone", 125.0, 12);
            Product Butler = new Product("Robot Butler", 225.0, 15);
            Product Dog = new Product("Robotic Dog", 150.0, 1);
            Product Vacuum = new Product("Robotic Vacuum", 250.0, 5);
            Product Chef = new Product("Robotic Chef", 150.0, 10);


            productRepository.save(Drone);
            productRepository.save(Butler);
            productRepository.save(Chef);
            productRepository.save(Dog);
            productRepository.save(Vacuum);



            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());

        }

    }
}