package com.gihub.zzz8y.fakkit;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FakkitAPI implements ModInitializer {
	public static final String MOD_ID = "fakkitapi";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("FakkitAPI initialized");
	}
}