package com.htmlhifive.testlib.it.util;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.htmlhifive.testlib.core.selenium.MrtCapabilities;

public class ItUtils {

	private ItUtils() {

	}

	/**
	 * 結果JSONからこのメソッドのスクリーンショットの結果を取得
	 *
	 * @param results
	 * @param capabilities
	 */
	public static JsonNode getCurrentScreenshotResultJson(String methodName, JsonNode results,
			MrtCapabilities capabilities) {
		for (JsonNode jn : results.get("screenshotResults")) {
			JsonNode capabilitiesNode = jn.get("capabilities");
			if (methodName.equals(jn.get("testMethod").asText())
					&& capabilities.getBrowserName().equals(capabilitiesNode.get("browserName").asText())) {
				JsonNode version = capabilitiesNode.get("version");
				if (version == null) {
					if (StringUtils.isEmpty(capabilities.getVersion())) {
						return jn;
					}
				} else {
					if (version.asText().equals(capabilities.getVersion())) {
						return jn;
					}
				}
			}
		}
		return null;
	}
}
