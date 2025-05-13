import java.util.Scanner;

//KARAKTERLERE AİT TEMEL BİLGİLER

public class SAVAŞÇILAR {
	public String isim;
	public int hasar;
	public int para;
	public int sağlık;
	public int id;
	public int seçim() {
		System.out.println("isim-->Samuray  "+ "Hasar: 5  "+ "  Sağlık: 21  "+ "   Para: 15  "+ " id: 1");
		System.out.println("isim-->okçu  "+ "   Hasar: 7  "+ "  Sağlık: 18  "+ "   Para: 20  "+ " id: 2");
		System.out.println("isim-->Şövalye  "+ "Hasar: 8  "+ "  Sağlık: 24  "+ "   Para: 5   "+  " id: 3");
		System.out.print("Seçmek istediğiniz savaşçının id=");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		return a;
	}
	public void samuray() {
		isim="Samuray";
		hasar=5;
		sağlık=21;
		para=15;
		id=1;
	}
	public void okçu() {
		isim="Okçu";
		hasar=7;
		sağlık=18;
		para=20;
		id=2;
	}
	public void şövalye() {
		isim="Şövalye";
		hasar=8;
		sağlık=24;
		para=5;
		id=3;
	}
	public void zombi() {
		isim="Zombi";
		hasar=3;
		sağlık=10;
		para=13;
		id=1;
	}
	public void vampir() {
		isim="Vampir";
		hasar=4;
		sağlık=14;
		para=15;
		id=2;
	}
	public void ayı() {
		isim="Ayı";
		hasar=7;
		sağlık=20;
		para=18;
		id=3;
	}
}
