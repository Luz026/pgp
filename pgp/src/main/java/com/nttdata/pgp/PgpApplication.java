package com.nttdata.pgp;

import lombok.extern.log4j.Log4j2;
import org.bouncycastle.openpgp.examples.KeyBasedFileProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

@SpringBootApplication
@Log4j2
public class PgpApplication {

	@Value("${outputPath}")
	private Resource outputPath;
	@Value("${inputResource}")
	private Resource inputResource;
	@Value("${publicKeyPath}")
	private Resource publicKeyPath;
	@Value("${privateKeyPath}")
	private Resource privateKeyPath;
	public static void main(String[] args) {
		SpringApplication.run(PgpApplication.class, args);
	}

	public void run(String... args) throws Exception {

		String outputFileName = outputPath.getFile().toPath().toString();
		String inputFileName = inputResource.getFile().toPath().toString();
		String publicFileName = privateKeyPath.getFile().toPath().toString();
		String privateFileName = publicKeyPath.getFile().toPath().toString();

		log.info("Decrypting {} ", inputFileName);

		KeyBasedFileProcessor.encryptFile(outputFileName, inputFileName, publicFileName, true, true);
	}



}
