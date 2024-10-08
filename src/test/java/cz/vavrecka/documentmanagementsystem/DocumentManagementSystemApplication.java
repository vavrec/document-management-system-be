package cz.vavrecka.documentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class DocumentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.from(DocumentManagementSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}
