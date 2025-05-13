import java.util.*;
public class ANA_MAİN_SINIFI {
	static SAVAŞÇILAR n=new SAVAŞÇILAR();
	static HashMap<String, Integer> gidilen_maplar=new HashMap<String, Integer>();
	static List<String> item=new ArrayList<String>();
	static boolean durum=true;
	static HARİTALAR k=new HARİTALAR();
	static int kazanılan_para=0;
	public static void kontrol_edici(List a) {
		if (a.size()==3) {
			System.out.println("Gerekli olan tüm itemler alındı başarıyla oyun tamamlanadı:)");
			durum=false;
		}
	}
	public static void main(String[] args) {
		int ek_hasar;
		int ek_savunma;
		gidilen_maplar.put("ORMAN", 0);
		gidilen_maplar.put("MAĞAZA", 0);
		gidilen_maplar.put("NEHİR", 0);
		gidilen_maplar.put("MAĞARA", 0);
			switch(n.seçim()) {
			case 1:
				n.samuray();
				break;
			case 2:
				n.okçu();
				break;
			case 3:
				n.şövalye();
				break;
			}
			System.out.println("Karakter seçimi başarıyla tamamlandı.");
			System.out.println("			\n");	
			while(durum) {
				System.out.println("Nereye gitmek istersiniz"+ "\n------------------"+ "\n->MAĞARA 1-3 ARASINDA ZOMBİ ÇIKABİLİR"+ "->KAZANILIRSA YEMEK İTEMİ ALINIP BÖLÜM GEÇİLECEK"
						+ "\n->ORMAN 1-3 ARASINDA VAMPİR ÇIKABİLİR KAZANILIRSA ODUN İTEMİ ALINIP BÖLÜM GEÇİLECEK"
						+ "\n->NEHİR 1-3 ARASINDA AYI ÇIKABİLİR KAZANILIRSA SU İTEMİ ALINIP BÖLÜM GEÇİLECEK"
						+ "\n->MAĞAZADA SİLAH VE ZIRH ALINACAK");
				System.out.println("MECVUT SAĞLIK: "+n.sağlık+" MEVCUT PARA: "+n.para+" MEVCUT SALDIRI:"+n.hasar);
				Scanner scan=new Scanner(System.in);
				String mekan=scan.next().toUpperCase();
				
				
				switch (mekan){
				case "ORMAN": {
					savaş_algoritması("ORMAN","Vampir","ODUN");
					kontrol_edici(item);
					break;
				}
				case "MAĞARA":{
					savaş_algoritması("MAĞARA", "Zombi","YEMEK");
					kontrol_edici(item);
					break;
				}
				case "NEHİR":{
					savaş_algoritması("NEHİR", "Ayı","SU");
					kontrol_edici(item);
					break;
				}
				case "MAĞAZA":{
					int arr[]=HARİTALAR.MAĞAZA(n.para);
					ek_hasar=arr[0];
					ek_savunma=arr[1];
					n.sağlık+=ek_savunma;
					n.hasar+=ek_hasar;
					n.para-=HARİTALAR.harcanan_miktar;
					HARİTALAR.harcanan_miktar=0;
					break;
				}
				case "GÜVENLİ EV":{	
				}
				break;	
			}			
}}
	public static void savaş_algoritması(String bölge,String düşman,String eşya) {
		if (gidilen_maplar.get(bölge)==1) {
			System.out.println("Buraya bir kez gidildi!!!");
			durum=true;
		}else {
		k.HARİTA(bölge);
		System.out.println("->"+k.a+" tane "+düşman +" karşına çıktı");
		System.out.println("\t\t\t\t!!!SAVAŞ BAŞLIYOR!!!");
		for(int i=1;i<=k.a;i++) {
			SAVAŞÇILAR z=new SAVAŞÇILAR();
			düşman=düşman.toUpperCase();
			if (düşman.equals("ZOMBİ")) {
				z.zombi();
			}else if(düşman.equals("AYI")) {
				z.ayı();
			}else if(düşman.equals("VAMPİR")) {
				z.vampir();
			}
			while(z.sağlık>0  & n.sağlık>0 ) {
				z.sağlık-=n.hasar;
				if (z.sağlık<=0) {
					break;
				}
				n.sağlık-=z.hasar;
				//sağlık=24 hasar=8 şövalye
				//zombi geldi sağlık=10 hasar=3   ve 3 tane zombi karşımıza çıktı
				//1.zs=2  şs=21
				//şs 21
				
		}
			kazanılan_para+=z.para;
			
			
			
		}
		
		if (n.sağlık<=0) {
			
			System.out.println("SAVAŞÇIN ÖLDÜ--------- GAME OVER -------");
			durum=false;
		}
		else {
			System.out.println("Savaş sonucunda "+n.sağlık+" canın kaldı");
			System.out.println(bölge+" bölgesini balşarıyla tamamladın karşılığında"
					+ kazanılan_para+" para ve "+eşya+" aldın");
			n.para+=kazanılan_para;
			kazanılan_para=0;
			item.add(eşya);
		}
		gidilen_maplar.put(bölge, 1);
	}
}
}