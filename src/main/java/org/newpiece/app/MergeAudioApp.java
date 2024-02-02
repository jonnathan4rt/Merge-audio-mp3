package org.newpiece.app;

import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import org.newpiece.domain.MergeAudioService;
import org.newpiece.util.MergeUtil;

public class MergeAudioApp {

    private static final String FOLDER_PATH = "C:\\Users\\Artic\\Downloads\\union\\";
    private static final String RESULT_FILE_NAME = "Merge-audio.mp3";
    private static final String EXTENSION_MP3 = ".mp3";

    public static void main(String[] args) {
        try {
            if (!MergeUtil.checkFolderExistence(FOLDER_PATH)) {
                System.out.println("The specified folder was not found.");
                return;
            }

            File folder = new File(FOLDER_PATH);
            File[] contentMp3 = folder.listFiles((dir, nombre) -> nombre.toLowerCase().endsWith(EXTENSION_MP3));

            if (contentMp3 == null || contentMp3.length == 0) {
                System.out.println("No MP3 files were found in the folder.");
                return;
            }

            MergeAudioService.mergeAllMP3(Arrays.asList(contentMp3), FOLDER_PATH + RESULT_FILE_NAME);

            System.out.println("MP3 files joined and saved successfully.");

        } catch (IOException e) {
            System.out.println("Error when merging MP3 files: " + e.getMessage());
        }
    }
}