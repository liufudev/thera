import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thera.config.ProviderConfig;

/**
 * @author liufu
 */
public class DemoTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("thera-provider.xml");
        ProviderConfig bean = applicationContext.getBean(ProviderConfig.class);
        System.out.println(bean);
    }
}
