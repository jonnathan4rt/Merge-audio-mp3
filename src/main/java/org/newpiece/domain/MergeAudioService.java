package org.newpiece.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MergeAudioService {

    private static final int BUFFER_SIZE = 1024;

    public static void mergeAllMP3(List<File> mp3Files, String resultFile) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(resultFile)) {
            for (File file : mp3Files) {
                try (FileInputStream inputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}
