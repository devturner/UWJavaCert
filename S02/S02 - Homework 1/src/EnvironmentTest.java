import org.junit.Test;
public class EnvironmentTest {

@Test
public void verifyEnvironment() {
    java.util.Properties sysProps = System.getProperties();
      for (Object key: sysProps.keySet()) {
        System.out.println(key + " = " + System.getProperty(key.toString()));
      }
  }
}
