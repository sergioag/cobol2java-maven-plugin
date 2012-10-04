package com.erpgenerator.cobol2java;

import java.io.File;

/**
 * Class: com.erpgenerator.cobol2java.CobolSourceFileInfo
 * User: sergioaguayo
 * Date: 10/3/12
 * Time: 5:59 PM
 */
public class CobolSourceFileInfo
{
    private final File sourceDirectory;
    private final String cobolFile;

    public CobolSourceFileInfo( File sourceDirectory, String cobolFile )
    {
        this.sourceDirectory = sourceDirectory;
        this.cobolFile = cobolFile;
    }

    public File getSourceDirectory()
    {
        return sourceDirectory;
    }

    public String getCobolFile()
    {
        return cobolFile;
    }
}
