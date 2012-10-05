package com.erpgenerator.cobol2java;

import org.codehaus.plexus.util.DirectoryScanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class: com.erpgenerator.cobol2java.CobolSourceDirectoryScanner
 * User: sergioaguayo
 * Date: 10/3/12
 * Time: 6:04 PM
 */
public class CobolSourceDirectoryScanner
{
    private DirectoryScanner            scanner;
    private List<CobolSourceFileInfo>   includedSourceFiles;

    public CobolSourceDirectoryScanner()
    {
        this.scanner = new DirectoryScanner();
        this.scanner.setFollowSymlinks( true );
        this.includedSourceFiles = new ArrayList<>();
    }

    public void setSourceDirectory( File directory )
    {
        if( !directory.isAbsolute() )
        {
            throw new IllegalArgumentException( "Source directory is not absolute: " + directory );
        }
        this.scanner.setBasedir( directory );
    }

    public void setIncludes( String includes[] )
    {
        this.scanner.setIncludes( includes );
    }

    public void scan() throws IOException
    {
        this.includedSourceFiles.clear();
        this.scanner.scan();

        String includedFiles[] = this.scanner.getIncludedFiles();
        for( int i = 0; i < includedFiles.length; i++ ) {
            String includedFile = includedFiles[i];
            CobolSourceFileInfo fileInfo = new CobolSourceFileInfo( this.scanner.getBasedir(), includedFile );
            includedSourceFiles.add( fileInfo );
        }
    }

    public CobolSourceFileInfo[] getIncludedSourceFiles()
    {
        return this.includedSourceFiles.toArray( new CobolSourceFileInfo[this.includedSourceFiles.size()] );
    }
}
