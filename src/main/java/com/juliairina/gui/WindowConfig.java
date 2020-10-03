package com.juliairina.gui;


public class WindowConfig {

    private static final int MAC_OS_X = 0;
    private static final int WINDOWS = 1;
    //main window
    private static final int[] SCREEN_WIDTH = new int[]{800, 1000};
    private static final int[] SCREEN_HEIGHT = new int[]{600, 800};
    //file name dialog
    private static final int[] FILE_NAME_DIALOG_SCREEN_WIDTH = {200, 300};
    private static final int[] FILE_NAME_DIALOG_SCREEN_HEIGHT = {90, 300};
    //
    private static final int SYS;
    private static final int screenWidth;
    private static final int screenHeight;
    private static final int authScreenWidth;
    private static final int authScreenHeight;
    private static final int fileNameDialogScreenWidth;
    private static final int fileNameDialogScreenHeight;

    static {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            SYS = MAC_OS_X;
        } else {
            SYS = WINDOWS;
        }
        screenWidth = SCREEN_WIDTH[SYS];
        screenHeight = SCREEN_HEIGHT[SYS];
        fileNameDialogScreenWidth = FILE_NAME_DIALOG_SCREEN_WIDTH[SYS];
        fileNameDialogScreenHeight = FILE_NAME_DIALOG_SCREEN_HEIGHT[SYS];

        authScreenWidth = screenWidth / 4;
        authScreenHeight = screenHeight / 7;
    }

    public static int getMacOsX() {
        return MAC_OS_X;
    }

    public static int getWINDOWS() {
        return WINDOWS;
    }

    public static int[] getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int[] getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static int getAuthScreenWidth() {
        return authScreenWidth;
    }

    public static int getAuthScreenHeight() {
        return authScreenHeight;
    }

    public static int[] getFileNameDialogScreenWidth() {
        return FILE_NAME_DIALOG_SCREEN_WIDTH;
    }

    public static int[] getFileNameDialogScreenHeight() {
        return FILE_NAME_DIALOG_SCREEN_HEIGHT;
    }

    public static int getSYS() {
        return SYS;
    }
}
