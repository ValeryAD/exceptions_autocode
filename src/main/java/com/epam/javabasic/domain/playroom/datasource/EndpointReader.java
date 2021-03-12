package com.epam.javabasic.domain.playroom.datasource;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.util.Optional.ofNullable;

/**
 * Created by anton_chyrko on 9/30/20.
 */
public class EndpointReader {

	private static EndpointReader endpointReader = null;

	public static EndpointReader getInstance() {
		return ofNullable(endpointReader).orElseGet(EndpointReader::new);
	}

	private EndpointReader() {
		endpointReader = this;
	}

	public String getEndpointContent(Endpoint endpoint) {
		String fileContent;
		StringBuilder result = new StringBuilder();

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(endpoint.getPath()).getFile());

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			JsonParser parser = new JsonParser();
			fileContent = parser.parse(result.toString()).toString();
		} catch (JsonSyntaxException ex) {
			fileContent = result.toString();
			fileContent = fileContent.replace("\n", "");
		}


		if (fileContent.equals("null")) return "";
		return fileContent;
	}

	public enum Endpoint {
		TOYS_BASE("data/toys_base.json"),
		TOYS_BASE_TEST("testData/toys_base_test.json");

		private final String path;

		Endpoint(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}
	}
}
