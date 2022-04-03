/**
*
* @author Ersin K�seo�lu - ersin.koseoglu@ogr.sakarya.edu.tr
* @since 02.04.2021
* <p>
* Operator ve Operand bilgisini tutan s�n�f
* </p>
* B191210016
* 1.��retim B grubu
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexical {
	
	//de�i�kenler
	public int tekliOperatorSayisi;
	public int ikiliOperatorSayisi;
	public int sayisalOperatorSayisi;
	public int iliskiselOperatorSayisi;
	public int mantiksalOperatorSayisi;
	public int toplamOperandSayisi;
	
	public int countOperator(String clean,String operator) {//operator saymak i�in 2 parametreli metod
		
		
		Pattern pattern=Pattern.compile(operator);
		Matcher matcher=pattern.matcher(clean);
		int sayac=0;
		
		while(matcher.find()) sayac++;//e�le�tik�e 1 arrt�r�yor 
		
		return sayac;
	}
	public int countOperand(String clean) {//operand saymak i�in tek parametreli metod
		
		Pattern pattern=Pattern.compile("[*&=!/]+|(?<!\\+)\\+(?!\\+)");
		Matcher matcher=pattern.matcher(clean);
		
		int sayac=0;
		while(matcher.find()) sayac+=2;//++ hari� di�er di�er operatorler 2 operanda ihtiya� duydu�u i�in operator e�le�ti�inde sayac 2 art�yor
		
		pattern=Pattern.compile("[+]{2}");
		matcher=pattern.matcher(clean);
		
		while(matcher.find()) sayac++;//burda da ++ g�r�nce 1 artt�r�nca sonuca ula��yoruz.
				
		
		return sayac;
	}
	
	public void setValue(String clean) { //de�i�kenlere de�er atamak i�in metod
		tekliOperatorSayisi=countOperator(clean,"(?<!\\w\\s)(\\+|-|!)+");
		ikiliOperatorSayisi=countOperator(clean,"(?<![+=!])[+*/=](?![+!=])");
		sayisalOperatorSayisi=countOperator(clean,"\\++|(?<![!=])[+!=*/](?![!=])");
		iliskiselOperatorSayisi=countOperator(clean,"(<|<=|>|>=|==|!=)");
		mantiksalOperatorSayisi=countOperator(clean,"[&!|]+(?!=)");
		toplamOperandSayisi=countOperand(clean);
		
	}
	
	
	public void print() {//bilgileri ekrana yazd�rmak i�in metod
		System.out.println("Operator Bilgisi : ");
		System.out.println("\tTekli Operator Sayisi : "+tekliOperatorSayisi);
		System.out.println("\tIkili Operator Sayisi : "+ikiliOperatorSayisi);
		System.out.println("\tSayisal Operator Sayisi : "+sayisalOperatorSayisi);
		System.out.println("\tIliskisel Operator Sayisi : "+iliskiselOperatorSayisi);
		System.out.println("\tMantiksal Operator Sayisi : "+mantiksalOperatorSayisi);
		System.out.println("Operand Bilgisi : ");
		System.out.println("\t Toplam Operand Sayisi : "+toplamOperandSayisi);
	}
	

}
