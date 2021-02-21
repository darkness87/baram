package com.darka.baram;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BaramMuhyulApplicationTests {

	@Autowired
	ResourceLoader resourceLoader;

	@Test
	public void jsonAnalysis() {
		Resource resource = resourceLoader.getResource("classpath:data/reference.record");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf8"));

			StringBuffer sb = new StringBuffer();
			String line = "";

			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			Resource r = resourceLoader.getResource("classpath:data/reference_dev.record");
			URI uri = r.getURI();
			log.info("{}", uri.getPath());
			File file = r.getFile();
			if (file.exists()) {
				file.createNewFile();
			}
			copyInputStreamToFile(resource.getInputStream(), file);
			log.info("{}", sb.toString());
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String prettyJsonString = gson.toJson(sb.toString());
			log.info("{}", prettyJsonString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
		Files.copy(inputStream, file.toPath());
	}

}
