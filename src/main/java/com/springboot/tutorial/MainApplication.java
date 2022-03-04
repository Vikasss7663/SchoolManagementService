package com.springboot.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}

/*

@Component
class MyRunner implements CommandLineRunner {

	@Autowired
	private Environment environment;

	MyRunner(Environment environment) {
		this.environment = environment;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(Arrays.toString(environment.getActiveProfiles()));

	}
}

@Component
@Profile("local")
class LocalRunner implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Local is active");

	}
}


@Component
@Profile("dev")
class DevRunner implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Development is active");

	}
}

@Component
@Profile("prod")
class ProdRunner implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Production is active");

	}
}

*/
