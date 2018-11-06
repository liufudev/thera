import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thera.config.ProviderConfig;

/**
 * @author liufu
 */
public class DemoTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("thera-provider.xml");
        applicationContext.start();
        ProviderConfig bean = applicationContext.getBean(ProviderConfig.class);
        System.out.println(bean);
    }
}
