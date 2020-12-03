package UI;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FilefilterType extends FileFilter{

	private  String extension;
	private  String description;
	
	
	
	public FilefilterType() {
		super();
	}

	public FilefilterType(String extension, String description) {
		super();
		this.extension = extension;
		this.description = description;
	}

	@Override
	public boolean accept(File f) {
		if(f.isDirectory()) 
		{
			return true;
		}
		return f.getName().endsWith(extension);
	}

	@Override
	public String getDescription() {
		
		return description+String.format("(*%s)", extension);
	}
	public String getExtension()
	{
		return this.extension;
	}
	public  boolean checkfile(File file) {
		if (file.getName().toLowerCase().endsWith("xls" )) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	

}
