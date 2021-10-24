/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private static final String DEFAULT_SARF_URL = "http://localhost:8080";
    private static final String DEFAULT_ROOTS_FILE = "alkhalil-all-roots.txt";
    private static final String SARF_API_URL_OPTION_SHORT = "s";
    private static final String SARF_API_URL_OPTION_LONG = "sarfApi";
    private static final String ROOTS_FILENAME_OPTION_SHORT = "r";
    private static final String ROOTS_FILENAME_OPTION_LONG = "roots";
    private static final String HELP_OPTION_SHORT = "h";
    private static final String HELP_OPTION_LONG = "help";

    public static void main(String[] args) throws ParseException, URISyntaxException, IOException, InterruptedException {
        var helpOption = new Option(HELP_OPTION_SHORT, HELP_OPTION_LONG, false, "help");
        var sarfApiOption = new Option(SARF_API_URL_OPTION_SHORT, SARF_API_URL_OPTION_LONG, true, "The Sarf API url" );
        var rootsOption = new Option(ROOTS_FILENAME_OPTION_SHORT, ROOTS_FILENAME_OPTION_LONG, true, "The roots file path" );

        sarfApiOption.setOptionalArg(false);
        rootsOption.setOptionalArg(false);

        var options = new Options();
        options.addOption(sarfApiOption);
        options.addOption(rootsOption);
        options.addOption(helpOption);

        var cmdParser = new DefaultParser();
        var cmd = cmdParser.parse(options, args);
        if(cmd.hasOption(HELP_OPTION_SHORT)) {
            printUsage(options);
            System.exit(0);
        }
        var programOptions = parseOptions(cmd);
        validateOptions(programOptions);
        new InvertedIndexBuilder(programOptions).run();
    }

    private static void validateOptions(ProgramOptions programOptions) throws FileNotFoundException {
        if(!Files.exists(Path.of(programOptions.getRootsFilename())))
        {
            throw new FileNotFoundException(String.format("Roots file does not exist, %s.", programOptions.getRootsFilename()));
        }
    }

    private static void printUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "inverted-index-builder", options );
    }

    private static ProgramOptions parseOptions(CommandLine cmd) {
        var programOptions = new ProgramOptions();
        var sarfUrl = cmd.getOptionValue(SARF_API_URL_OPTION_SHORT, DEFAULT_SARF_URL);
        var rootsFile = cmd.getOptionValue(ROOTS_FILENAME_OPTION_SHORT, DEFAULT_ROOTS_FILE);
        programOptions.setSarfUri(sarfUrl);
        programOptions.setRootsFilename(rootsFile);
        return programOptions;
    }
}
