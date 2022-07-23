package quan_li_nhan_su;

public class TruongPhong extends NhanVien {
	private int soLuongNv;

	
	public TruongPhong() {
		super();
		this.luongMotNgay = 200;
		this.id = "tp";
		this.soLuongNv = 0;
	}
	
	@Override
	public void nhap() {
		super.nhap();
	}
	
	@Override
	public double tinhLuongThang() {
		this.luongThang = this.luongMotNgay * this.getSoNgayLamViec() + 100 * this.soLuongNv;
		return this.luongThang;
	}
	
	@Override
	public void xuat() {
		System.out.println("***Truong Phong***");
		super.xuat();
		System.out.println("So luong nhan vien: " + this.soLuongNv + " nhan vien");
		System.out.println("Luong thang: " + this.tinhLuongThang() + "d");
	}
	
	public void increaseSoLuongNv() {
		this.soLuongNv++;
	}
	
	public void decreaseSoLuongNv() {
		this.soLuongNv--;
	}
	
	public int getSoLuongNv() {
		return soLuongNv;
	}

	public void setSoLuongNv(int soLuongNv) {
		this.soLuongNv = soLuongNv;
	}
	
	
}
