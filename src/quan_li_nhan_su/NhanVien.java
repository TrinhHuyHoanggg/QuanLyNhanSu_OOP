package quan_li_nhan_su;


import java.util.Scanner;

public class NhanVien implements Comparable<NhanVien> {
	protected String msNhanVien, tenNhanVien, sdt;
	protected int soNgayLamViec;
	protected double luongMotNgay, luongThang;
	protected String id; // Nhan biet chuc vu
	Scanner scan = new Scanner(System.in);
	
	
	public NhanVien() {
		this.msNhanVien = "";
		this.tenNhanVien = "";
		this.sdt = "";
		this.soNgayLamViec = 0;
		this.luongMotNgay = 0;
		this.luongThang = 0;
		this.id = "";
	};
	
	public NhanVien(String msNhanVien, String tenNhanVien, String sdt, int soNgayLamViec, double luongMotNgay, String id) {
		this.msNhanVien = msNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.sdt = sdt;
		this.soNgayLamViec = soNgayLamViec;
		this.luongMotNgay = luongMotNgay;
		this.id = id;
	}

	public void nhap() {
		System.out.print("Nhap ms nhan vien: ");
		msNhanVien = scan.nextLine();
		System.out.print("Nhap ten nhan vien: ");
		tenNhanVien = scan.nextLine();
		System.out.print("Nhap sdt nhan vien: ");
		sdt = scan.nextLine();
		System.out.print("Nhap so ngay lam viec: ");
		soNgayLamViec = scan.nextInt();
		scan.nextLine();
	}
	
	public void xuat() {
		System.out.println("MSNV: " + this.msNhanVien);
		System.out.println("Ho ten: " + this.tenNhanVien);
		System.out.println("Sdt: " + this.sdt);
		System.out.println("So ngay lam viec: " + this.soNgayLamViec);	
	}
	
	public double tinhLuongThang() {
		return 0;
	}
	
	public String getMsNhanVien() {
		return msNhanVien;
	}

	public void setMsNhanVien(String msNhanVien) {
		this.msNhanVien = msNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public double getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(double luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	public double getLuongThang() {
		return luongThang;
	}

	public void setLuongThang(double luongThang) {
		this.luongThang = luongThang;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int compareTo(NhanVien nv) {
		return this.getTenNhanVien().compareTo(nv.tenNhanVien);
	}

}
