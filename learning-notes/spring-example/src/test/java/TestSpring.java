import org.charles.learning.entity.Coffee;
import org.charles.learning.entity.CoffeeMaker;
import org.charles.learning.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coffee coffee = (Coffee) applicationContext.getBean("coffee");

        System.out.println(coffee);

        CoffeeMaker coffeeMaker = (CoffeeMaker) applicationContext.getBean("coffeeMaker");
        System.out.println(coffeeMaker.makeCoffee());


        ProductService productService = (ProductService) applicationContext.getBean("productService");
        productService.doSomeService();
        productService.executeSomeService();
    }
}
