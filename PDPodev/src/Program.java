/**
*
* @author Ersin Köseoðlu - ersin.koseoglu@ogr.sakarya.edu.tr
* @since 02.04.2022
* <p>
* Programýn çalýþtýrýlacaðý sýnýf
* </p>
* B191210016
* 1.Öðretim B grubu
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
	
	public static void main(String[] args) {
		Lexical lexical=new Lexical();
		String fileName="C:\\Users\\mgame\\eclipse-workspace\\PDPodev\\src\\"+args[0];//komut satýrý parametresi olarak girilen dosya adýný programýn okuyabilmesi icin yoluyla birlestiriyorum.
		String metin="";//Deneme.java'yý bu deðiþkenin içinde tutacaðýz.
		try {
			metin=readFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String clean = metin.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)", "");//yorum satýrlarýný silme
		lexical.setValue(clean);
		lexical.print();
		
	}
	public static String readFile(String fileName) throws IOException { //dosya okumak için metod
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
}



