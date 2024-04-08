package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Customer;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerRepository.class);
    public CustomerRepository() {
        File file = new File(DATABASE_NAME);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "data/customers.txt";
    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
    public void save(Customer customer) throws Exception {
        Path path = Paths.get(DATABASE_NAME);
        String password = customer.password();
        String data = customer.username() + "," + password + "," + customer.email();
        appendToFile(path, data + NEW_LINE);
    }
}
