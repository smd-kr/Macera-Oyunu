import java.awt.MediaTracker;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class HARİTALAR {
	static HashMap<String, Integer> alınan_silah_kalkan=new HashMap<String, Integer>();
	static int a;
    static public int kazanılan_para;
    static public int harcanan_miktar=0;
    static int ek_saldırı;
    
    
    //BURASI ALINIP ALINMAYAN ŞEYLERİ KONTROL EDER
    public static boolean kotnrol_edici(String a) {
    	try {
			if (alınan_silah_kalkan.get(a)==0) {
				
			}
			return false;
		} catch (Exception e) {
			return true;
		}
    }
    
    
	public void HARİTA(String B) {
		Random rand=new Random();
		if (B.equals("ORMAN")) {
			a=rand.nextInt(1, 4);
		}
		else if(B.equals("MAĞARA")) {
			a=rand.nextInt(1, 4);
		}
		else if(B.equals("NEHİR")) {
			a=rand.nextInt(1, 4);
		}
	}
	
	public static int[] MAĞAZA(int mevcut_para) {
		
		Scanner scan=new Scanner(System.in);
		HARİTALAR.ek_saldırı=0;
		int ek_savunma=0;
		while(true) {
		System.out.println("Hangi reyona gitmek istersinz:"
				+ "\nSilah reyonu için 1'i\n"
				+ "Zırh reyonu için 2'yi\n"
				+ "Çıkmak için 3'ü");
		//ek hasar=12  ek_savunma=+9
		int b=scan.nextInt();
		if (b==1) {
			
			//SİLAH ALMA BÖLÜMÜ
			
			while(true) {
				System.out.println("ID   SİLAH     HASAR-ARTIŞI      FİYAT\n"
						+ 		   "1    TABANCA        +2			  25TL\n"
						+ 		   "2    KILIÇ          +3            35TL\n"
						+ 		   "3    TÜFEK          +7            45TL\n");
				System.out.println("Hangi silahı almak istersiniz Çıkmak için=0");
				System.out.println("MEVCUT BAKİYE:"+(mevcut_para));
				int a=scan.nextInt();
			if (a==0) {
				break;
			}
			else if (a==1) {
				if (kotnrol_edici("TABANCA")) {
					if (mevcut_para>=25) {
						ANİMATİON.animation("TABANCA", 2);
						mevcut_para-=25;
						harcanan_miktar+=25;
						System.out.println("Bir üst menü için 1 çıkmak için 0");
						if (scan.nextInt()==0) {
							break;
						}
						continue;
					}
					else {
						System.out.println("Bakiye yetersiz bir üst menü için 1 çıkmak için 0");
						
						if (scan.nextInt()==0) {
							break;
						}
						continue;
					}
				}else {
					System.out.println("TABANCA BİR KEZ ALINDI BİR KEZ DAHA ALINAMAZ");
					continue;
				}
			}else if(a==2) {
				if (kotnrol_edici("KILIÇ")) {
					if (mevcut_para>=35) {
						ANİMATİON.animation("KILIÇ", 3);
						mevcut_para-=35;
						harcanan_miktar+=35;
						System.out.println("Bir üst menü için 1 çıkmak için 0");
						if (scan.nextInt()==0) {
							break;
						}
						continue;
					}			else {
						System.out.println("Bakiye yetersiz bir üst menü için 1 mağazadan çıkmak için 0");
						
						if (scan.nextInt()==0) {
							break;
						}
						continue;
					}
				}
				else {
					System.out.println("KILIÇ BİR KEZ ALINMIŞ BİR DAHA ALINAMAZ");
					continue;
				}
			}else if(a==3) {
				if (kotnrol_edici("TÜFEK")) {
					if (mevcut_para>=45) {
						ANİMATİON.animation("TÜFEK", 7);
						mevcut_para-=45;
						harcanan_miktar+=45;
						System.out.println("Bir üst menü için 1 çıkmak için 0");
						if (scan.nextInt()==0) {
							break;
						}
						continue;
					}			else {
						System.out.println("Bakiye yetersiz bir üst menü için 1 mağazadan çıkmak için 0");
						int k=scan.nextInt();
						if (k==0) {
							break;
						}
						continue;
					}
				}
					else {
						System.out.println("TÜFEK BİR KEZ ALINMIŞ BİRDAHA ALINAMAZ");
						continue;
					}
			}
			else {
				System.out.println("Adam akıllı tuşlama yap!!!");
				continue;
			}
		}
			continue;	
		}//SİLAH ALMA REYONU SONU
		else if(b==2) {
			//ZIRH ALMA BÖLÜMÜ
			
			while(true) {
				System.out.println("ID   ZIRH     SAVUNMA-ARTIŞI      FİYAT\n"
						+ 		   "1    HAFİF        +6			   15TL"
						+ 		   "2    ORTA         +9               25TL"
						+ 		   "3    AĞIR         +12              40TL");
				System.out.println("Hangi zırhı almak istersiniz. (Çıkmak için=0)");
				System.out.println("MEVCUT BAKİYE:"+(mevcut_para));
				int a=scan.nextInt();
			if (a==1) {
				if (kotnrol_edici("HAFİF")) {
					if (mevcut_para>=15) {
						System.out.println("Haifif başarılı ile takıldı");
						alınan_silah_kalkan.put("HAFİF", 1);
						mevcut_para-=15;
						harcanan_miktar+=15;

						ek_savunma+= 6;
						System.out.println("Bir üst menü için 1 çıkmak için 0");
						if (scan.nextInt()==0) {
							break;
						}
						continue;
						
					}
					else {
						System.out.println("Bakiye yetersiz üst menü için için 1 mağazadan çıkmak için 0");
						int k=scan.nextInt();
						if (k==0) {
							break;
						}
						continue;
					}
				}
				else {
					System.out.println("HAFİF KALKANI ALINMIŞ BİRDAHA ALINAMAZ");
				}
			}
			else if(a==2) {
				if (kotnrol_edici("ORTA")) {
					if (mevcut_para>=25) {
						System.out.println("Orta başarılı ile takıldı");
						alınan_silah_kalkan.put("ORTA", 1);
						mevcut_para-=25;
						harcanan_miktar+=25;

						ek_savunma+= 9;System.out.println("Bir üst menü için 1 çıkmak için 0");
						if (scan.nextInt()==0) {
							break;
						}
						continue;
					}			else {
						System.out.println("Bakiye yetersiz üst menü için için 1 mağazadan çıkmak için 0");
						int k=scan.nextInt();
						if (k==0) {
							break;
						}
						continue;
					}
				}
				else {
					System.out.println("ORTA KALKANI ALINMIŞ BİRDAHA ALINAMAZ");
				}
			}else if(a==3) {
				if (kotnrol_edici("AĞIR")) {
					if (mevcut_para>=40) {
						System.out.println("Ağır başarılı ile takıldı");
						mevcut_para-=40;
						harcanan_miktar+=40;
						alınan_silah_kalkan.put("AĞIR", 1);

						ek_savunma+= 12;
						System.out.println("Bir üst menü için 1 çıkmak için 0");
						if (scan.nextInt()==0) {
							break;
						}
						continue;
					}			else {
						System.out.println("Bakiye yetersiz üst menü için 1 mağazadan çıkmak için 0");
						int k=scan.nextInt();
						if (k==0) {
							break;
						}
						continue;
					}
				}else {
					System.out.println("AĞIR KALKANI ALINMIŞ BİRDAHA ALINAMAZ");
				}

			}
			else if(a==0) {
				break;
			}
			else {
				System.out.println("Adam akıllı tuşlama yap!!!");
				continue;
			}
			}	
		}//ZIRH ALMA SONU
		else {
			System.out.println("Mağazadan çıkış yapıldı");
		}
		break;
		}
		return new int[] {ek_saldırı,ek_savunma};
	}	
}
