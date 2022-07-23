package quan_li_nhan_su;

import java.util.Scanner;

public class CongTy {
	private String tenCongTy, msThue;
	private double doanhThuThang;
	
	public CongTy () {};
	
	public CongTy(String tenCongTy, String msThue, double doanhThuThang) {
		this.tenCongTy = tenCongTy;
		this.msThue = msThue;
		this.doanhThuThang = doanhThuThang;
	}

	public void nhapInfoCongTy() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap ten cong ty: ");
		tenCongTy = scan.nextLine();
		System.out.print("Nhap ms thue: ");
		msThue = scan.nextLine();
		System.out.print("Nhap doanh thu thang: ");
		doanhThuThang= scan.nextDouble();
		scan.nextLine();
	}
	
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMsThue() {
		return msThue;
	}

	public void setMsThue(String msThue) {
		this.msThue = msThue;
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double d) {
		this.doanhThuThang = d;
	}
	
	
}
