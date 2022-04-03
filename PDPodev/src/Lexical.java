/**
*
* @author Ersin Köseoðlu - ersin.koseoglu@ogr.sakarya.edu.tr
* @since 02.04.2021
* <p>
* Operator ve Operand bilgisini tutan sýnýf
* </p>
* B191210016
* 1.Öðretim B grubu
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexical {
	
	//deðiþkenler
	public int tekliOperatorSayisi;
	public int ikiliOperatorSayisi;
	public int sayisalOperatorSayisi;
	public int iliskiselOperatorSayisi;
	public int mantiksalOperatorSayisi;
	public int toplamOperandSayisi;
	
	public int countOperator(String clean,String operator) {//operator saymak için 2 parametreli metod
		
		
		Pattern pattern=Pattern.compile(operator);
		Matcher matcher=pattern.matcher(clean);
		int sayac=0;
		
		while(matcher.find()) sayac++;//eþleþtikçe 1 arrtýrýyor 
		
		return sayac;
	}
	public int countOperand(String clean) {//operand saymak için tek parametreli metod
		
		Pattern pattern=Pattern.compile("[*&=!/]+|(?<!\\+)\\+(?!\\+)");
		Matcher matcher=pattern.matcher(clean);
		
		int sayac=0;
		while(matcher.find()) sayac+=2;//++ hariç diðer diðer operatorler 2 operanda ihtiyaç duyduðu için operator eþleþtiðinde sayac 2 artýyor
		
		pattern=Pattern.compile("[+]{2}");
		matcher=pattern.matcher(clean);
		
		while(matcher.find()) sayac++;//burda da ++ görünce 1 arttýrýnca sonuca ulaþýyoruz.
				
		
		return sayac;
	}
	
	public void setValue(String clean) { //deðiþkenlere deðer atamak için metod
		tekliOperatorSayisi=countOperator(clean,"(?<!\\w\\s)(\\+|-|!)+");
		ikiliOperatorSayisi=countOperator(clean,"(?<![+=!])[+*/=](?![+!=])");
		sayisalOperatorSayisi=countOperator(clean,"\\++|(?<![!=])[+!=*/](?![!=])");
		iliskiselOperatorSayisi=countOperator(clean,"(<|<=|>|>=|==|!=)");
		mantiksalOperatorSayisi=countOperator(clean,"[&!|]+(?!=)");
		toplamOperandSayisi=countOperand(clean);
		
	}
	
	
	public void print() {//bilgileri ekrana yazdýrmak için metod
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
