package cz.vavrecka.documentmanagementsystem.party;



import cz.vavrecka.documentmanagementsystem.DocumentManagementSystemApplicationTest;
import cz.vavrecka.documentmanagementsystem.TestContainerConfiguration;
import cz.vavrecka.documentmanagementsystem.party.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

//@DataR2dbcTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import(value = {TestContainerConfiguration.class, DocumentManagementSystemApplicationTest.class})

public class UserRepositoryIntegrationTest {


    @Autowired
    UserRepository userRepository;

    @Test
    void selectAllPageable(){
        userRepository.count().block();
    }

}
