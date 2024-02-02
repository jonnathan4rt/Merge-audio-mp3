package org.newpiece.util;

import java.io.File;

public class MergeUtil {

    public static boolean checkFolderExistence(String folderPath) {
        File folder = new File(folderPath);
        return folder.exists() && folder.isDirectory();
    }
}