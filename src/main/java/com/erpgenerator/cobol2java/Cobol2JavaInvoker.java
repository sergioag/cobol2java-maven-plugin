package com.erpgenerator.cobol2java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class: com.erpgenerator.cobol2java.Cobol2JavaInvoker
 * User: sergioaguayo
 * Date: 10/4/12
 * Time: 12:15 PM
 */
public class Cobol2JavaInvoker
{
    private String      dataPackageName;
    private String      programPackageName;
    private String      sourceFormat;
    private File        outputDirectory;
    private File        sourceFile;

    public String getDataPackageName()
    {
        return dataPackageName;
    }

    public void setDataPackageName( String dataPackageName )
    {
        this.dataPackageName = dataPackageName;
    }

    public String getProgramPackageName()
    {
        return programPackageName;
    }

    public void setProgramPackageName( String programPackageName )
    {
        this.programPackageName = programPackageName;
    }

    public String getSourceFormat()
    {
        return sourceFormat;
    }

    public void setSourceFormat( String sourceFormat )
    {
        this.sourceFormat = sourceFormat;
    }

    public File getOutputDirectory()
    {
        return outputDirectory;
    }

    public void setOutputDirectory( File outputDirectory )
    {
        this.outputDirectory = outputDirectory;
    }

    public File getSourceFile()
    {
        return sourceFile;
    }

    public void setSourceFile( File sourceFile )
    {
        this.sourceFile = sourceFile;
    }

    private String[] buildArguments()
    {
        List<String> argsList = new ArrayList<>(  );

        argsList.add( "-odir" );
        argsList.add( outputDirectory.getAbsolutePath() );
        argsList.add( "-dp" );
        argsList.add( dataPackageName );
        argsList.add( "-pp" );
        argsList.add( programPackageName );
        argsList.add( "-" + sourceFormat );
        argsList.add( "-c3" );
        argsList.add( "-opt2" );
        argsList.add( sourceFile.getAbsolutePath() );

        return argsList.toArray( new String[ argsList.size() ] );
    }
    public void execute()
        throws Exception
    {
        if( outputDirectory.exists() && !outputDirectory.isDirectory() )
        {
            throw new Exception( "Output directory must be a directory, not a file" );
        }
        if( !outputDirectory.exists() )
            outputDirectory.mkdirs();

        com.res.cobol.Main.main( buildArguments() );
    }
}
