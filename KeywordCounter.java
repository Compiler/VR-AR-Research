
import java.io.*;
import java.util.*;

public class  KeywordCounter{
//package, import, this, voi, private, public, 

	
	private ArrayList<String> info;
	private int lineCount = 0;
	

	private HashMap<String, Integer> keywordMap;
	private TreeMap<Integer, String> sortedMap;
	private static final String KEYWORDS[] = {
		"package", "import", "this", "void", "public", "private", "protected", "try", "catch", "static", "volatile",
		"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default",
		"double", "do", "else", "enum", "extends", "final", "float", "for", "if", "implements", "instanceof", 
		"int", "interface", "long", "native", "new", "return", "short", "strictfp", "super", "switch",
		"synchornized", "this", "throw", "throws", "transient", "while"
		};

	public KeywordCounter(String filePath){
		this.keywordMap = new HashMap<String, Integer>();
		this.info = new ArrayList<String>();

		File file = new File(filePath);
		try{
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				info.add(scan.nextLine());
				lineCount++;
			}


			scan.close();

		}catch(FileNotFoundException e){ e.printStackTrace(); }

		System.out.println("File read\n");
		info.clear();
		info.add("int double ////int double");
		info.add("//* int int int int int");
		info.add("int int *// int");
		clearLiterals();
	}


	private void clearLiterals(){
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < info.size(); i ++){
