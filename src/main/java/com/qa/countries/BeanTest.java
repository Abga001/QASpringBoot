@SpringBootApplication
public class SpringExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringExampleApplication.class, args);
    }

    @Bean
    public String greeting() {
        return "Hello, World";
    }
}