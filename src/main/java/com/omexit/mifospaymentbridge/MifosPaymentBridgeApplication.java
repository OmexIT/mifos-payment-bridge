package com.omexit.mifospaymentbridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:integrations/integration-context.xml")
public class MifosPaymentBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MifosPaymentBridgeApplication.class, args);
	}
}
