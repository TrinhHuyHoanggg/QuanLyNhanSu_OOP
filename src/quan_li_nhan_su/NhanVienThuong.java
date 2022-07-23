package quan_li_nhan_su;

public class NhanVienThuong extends NhanVien {
	private TruongPhong truongPhong;

	
	public NhanVienThuong() {
		super();
		this.luongMotNgay = 100;
		this.id = "nvt";
		this.truongPhong = null;
	}
	
	@Override
	public void nhap() {
		super.nhap();
	}
	
	@Override
	public double tinhLuongThang() {
		this.luongThang = this.luongMotNgay * this.getSoNgayLamViec();
		return this.luongThang;
	}
	
	@Override
	public void xuat() {
		System.out.println("***Nhan Vien Thuong***");
		super.xuat();
		if(this.truongPhong != null)
			System.out.println("Truong phong: " + this.truongPhong.tenNhanVien);
		else
			System.out.println("Khong co truong phong!");
		System.out.println("Luong thang: " + this.tinhLuongThang() + "d");
	}
	
	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}
	

}
