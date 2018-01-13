package com.jotov.skyrunrating;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class SkyrunratingApplication {
	private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB

	public static void main(String[] args) {
		SpringApplication.run(SkyrunratingApplication.class, args);
	}

	//Tomcat large file upload connection reset
	//http://www.mkyong.com/spring/spring-file-upload-and-connection-reset-issue/
	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {

		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

		tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
				//-1 means unlimited
				((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
			}
		});

		return tomcat;

	}

	// TODO - to move as Bean
	public static Duration parseStringToDuration(String input) {
		String[] parts = input.split ( ":" );
		Duration d = Duration.ZERO;
		if ( parts.length == 3 ) {
			int hours = Integer.parseInt ( parts[ 0 ] );
			int minutes = Integer.parseInt ( parts[ 1 ] );
			int seconds = Integer.parseInt ( parts[ 2 ] );
			d = d.plusHours ( hours ).plusMinutes ( minutes ).plusSeconds ( seconds );
		} else if ( parts.length == 2 ) {
			int hours = Integer.parseInt ( parts[ 0 ] );
			int minutes = Integer.parseInt ( parts[ 1 ] );
			d = d.plusHours ( hours ).plusMinutes ( minutes );
		} else {
			System.out.println ( "ERROR - Unexpected input." );
		}
		return d;
	}
}
