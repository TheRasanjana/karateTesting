package features.products;

import com.intuit.karate.FileUtils;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import com.intuit.karate.netty.FeatureServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Karate.class )
@KarateOptions(tags = "~@ignore")
public class productsRunner {
    private static FeatureServer server;

    @BeforeClass
    public static void beforeClass() {
         System.setProperty("karate.env", "mock");
        File file = FileUtils.getFileRelativeTo(productsRunner.class, "products-mock.feature");
        server = FeatureServer.start(file, 8089, false, null );
        String paymentServiceUrl = "http://localhost:" + server.getPort();
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }
}