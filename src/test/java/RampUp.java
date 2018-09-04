import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //glue =  "src/test/resources/steps",
        features = "src/test/resources/features")
public class RampUp {

}
