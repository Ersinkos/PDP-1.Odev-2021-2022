/**
*
* @author Ersin K�seo�lu - ersin.koseoglu@ogr.sakarya.edu.tr
* @since 02.04.2022
* <p>
* Program�n �al��t�r�laca�� s�n�f
* </p>
* B191210016
* 1.��retim B grubu
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
	
	public static void main(String[] args) {
		Lexical lexical=new Lexical();
		String fileName="C:\\Users\\mgame\\eclipse-workspace\\PDPodev\\src\\"+args[0];//komut sat�r� parametresi olarak girilen dosya ad�n� program�n okuyabilmesi icin yoluyla birlestiriyorum.
		String metin="";//Deneme.java'y� bu de�i�kenin i�inde tutaca��z.
		try {
			metin=readFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String clean = metin.replaceAll("(/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/)|(//.*)", "");//yorum sat�rlar�n� silme
		lexical.setValue(clean);
		lexical.print();
		
	}
	public static String readFile(String fileName) throws IOException { //dosya okumak i�in metod
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



