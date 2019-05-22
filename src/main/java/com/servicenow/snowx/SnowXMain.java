package com.servicenow.snowx;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.servicenow.snowx.exception.AppException;
import com.servicenow.snowx.model.HPShip;
import com.servicenow.snowx.model.HPTorpedo;
import com.servicenow.snowx.model.SnowX;
import com.servicenow.snowx.model.Target;
import com.servicenow.snowx.utils.FileUtils;
import com.servicenow.snowx.utils.Utils;

public class SnowXMain {

	private static final Logger LOGGER = Logger.getLogger(SnowXMain.class.getName());
	private static final String DEFAULT_FILE_PATH_HP_SHIP = new File("src/main/resources/HPShip.snw").getAbsolutePath();
	private static final String DEFAULT_FILE_PATH_HP_TORPEDO = new File("src/main/resources/HPTorpedo.snw").getAbsolutePath();

	private static final String OPTION_KEY_SNOWX = "x";
	private static final String OPTION_KEY_HP_SHIP = "s";
	private static final String OPTION_KEY_HP_TORPEDO = "t";

	private static Options createCliOptions() {
		final Options options = new Options();
		options.addOption(Option.builder(SnowXMain.OPTION_KEY_SNOWX).hasArg().desc("SnowX data input file path")
				.required().build());
		options.addOption(
				Option.builder(SnowXMain.OPTION_KEY_HP_SHIP).hasArg().desc("HPship data input file path").build());
		options.addOption(Option.builder(SnowXMain.OPTION_KEY_HP_TORPEDO).hasArg()
				.desc("HPtorpedo data input file path").build());
		return options;
	}

	public static void main(final String[] args) throws AppException {
		final Options options = SnowXMain.createCliOptions();
		final CommandLineParser parser = new DefaultParser();
		try {
			final CommandLine cmd = parser.parse(options, args);
			final String filePathSnowX = cmd.getOptionValue(SnowXMain.OPTION_KEY_SNOWX);
			final String filePathHPShip = cmd.getOptionValue(SnowXMain.OPTION_KEY_HP_SHIP, SnowXMain.DEFAULT_FILE_PATH_HP_SHIP);
			final String filePathHPTorpedo = cmd.getOptionValue(SnowXMain.OPTION_KEY_HP_TORPEDO,
					SnowXMain.DEFAULT_FILE_PATH_HP_TORPEDO);

			final SnowX snowX = new SnowX(FileUtils.readDataFromFile(filePathSnowX));
			final HPShip ship = new HPShip(FileUtils.readDataFromFile(filePathHPShip));
			final HPTorpedo torpedo = new HPTorpedo(FileUtils.readDataFromFile(filePathHPTorpedo));

			final List<Target> targets = Utils.analysis(snowX, ship, torpedo);
			if (SnowXMain.LOGGER.isLoggable(Level.INFO)) {
				SnowXMain.LOGGER.info(targets.stream().map(Target::toString).collect(Collectors.joining("\n", "", "")));
			}
		} catch (final ParseException e) {
			final HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("snowx", options);
			System.exit(1);
		}
	}
}
