import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features={"src/test/java/features/womendress.feature", "src/test/java/features/Cookies.feature", "src/test/java/features/Register.feature","src/test/java/features/InvalidRegister.feature","src/test/java/features/LogIn.feature","src/test/java/features/InvalidLogIn.feature","src/test/java/features/LogOut.feature" ,"src/test/java/features/DeleteAccount.feature","src/test/java/features/afegirproductescarrito.feature","src/test/java/features/subscribe.feature"  }, glue="steps")
public class RunDressTest extends AbstractTestNGCucumberTests{

}

