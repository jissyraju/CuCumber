import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags="@searchByInvalid", plugin = {"pretty", "html:target/tsr.html"})
public class Run {

}
