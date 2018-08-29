import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //glue =  "src/test/resources/steps",
        features = "src/test/resources/consultJoiners.feature")
public class RampUp {
    /*@Test
    public void Test() {
        String query = "Luis";
        String email = "admin@endava.com";
        String password = "admin";
        LoginPage loginPage = new LoginPage(driver);
        DashBoardPage dashBoard = loginPage.login(email, password);

        JoinerManagerPage ap = dashBoard.go();
        //ap.search(query);

        assertThat("Title should match the expected",
                ap.search(query),
                containsString(query));
    }*/
}
