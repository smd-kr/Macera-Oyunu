
public class ANİMATİON {
	public static void animation(String name,int ek_saldırı) {
		System.out.println(name+" başarılı ile alındı");
		HARİTALAR.alınan_silah_kalkan.put(name, 1);
		HARİTALAR.ek_saldırı+=ek_saldırı;
		
	}
}
