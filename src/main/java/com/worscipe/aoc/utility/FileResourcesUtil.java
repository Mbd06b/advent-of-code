package com.worscipe.aoc.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileResourcesUtil {
 

        

        /**
         * Returns a list of lines from a resource file.
         * 
         * @param resourcePath path Ex. "/words.txt"
         * @return
         * @throws IOException
         */
        public static List<String> getLines(final String resourcePath) throws IOException {
            List<String> lines = new ArrayList<>();
            final InputStream is = FileResourcesUtil.class.getClassLoader().getResourceAsStream(resourcePath);
            if( is == null){
                System.out.println("Input Stream is null");
            } else {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                } 
            }
            return lines;
        };

        /**
         * useless research method for exploring adding IO. anyone know how to quick
         * comment in Theia IDE?
         */
        private void doNothingForNow() {

            final FileResourcesUtil app = new FileResourcesUtil();

            // read all files from a resources folder
            try {

                // files from src/main/resources/json
                final List<File> result = app.getAllFilesFromResource("json");
                for (final File file : result) {
                    System.out.println("file : " + file);
                    printFile(file);
                }

            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }

        }

        private List<File> getAllFilesFromResource(final String folder) throws URISyntaxException, IOException {

            final ClassLoader classLoader = getClass().getClassLoader();

            final URL resource = classLoader.getResource(folder);

            // dun walk the root path, we will walk all the classes
            final List<File> collect = Files.walk(Paths.get(resource.toURI())).filter(Files::isRegularFile)
                    .map(x -> x.toFile()).collect(Collectors.toList());

            return collect;
        }

        // print a file
        private static void printFile(final File file) {

            List<String> lines;
            try {
                lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
                lines.forEach(System.out::println);
            } catch (final IOException e) {
                e.printStackTrace();
            }

        }
}