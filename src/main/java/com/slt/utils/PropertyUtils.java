package com.slt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.slt.constants.FrameworkConstants;
import com.slt.enums.ConfigProperties;

public final class PropertyUtils {

	private PropertyUtils() { }

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();


	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigrPath());
			property.load(file);

			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces
			}
		}

		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) throws Exception  {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
