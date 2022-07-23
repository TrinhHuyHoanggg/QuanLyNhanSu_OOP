package quan_li_nhan_su;

public class GiamDoc extends NhanVien {
	private float coPhanTrongCty;
	
	public GiamDoc() {
		super();
		this.luongMotNgay = 300;
		this.id = "gd";
		this.coPhanTrongCty = 0;
	}
	
	@Override
	public void nhap() {
		super.nhap();
		System.out.print("Nhap so co phan trong cong ty: ");
		coPhanTrongCty = scan.nextFloat();
		if(coPhanTrongCty < 0 || coPhanTrongCty > 100) {
			do {
				System.out.print("Nhap lai so co phan trong cong ty: ");
				coPhanTrongCty = scan.nextFloat();
			} while(coPhanTrongCty < 0 || coPhanTrongCty > 100);
		}
	}
	
	@Override
	public double tinhLuongThang() {
		this.luongThang = this.luongMotNgay * this.getSoNgayLamViec();
		return this.luongThang;
	}
	
	@Override
	public void xuat() {
		System.out.println("***Giam Doc***");
		super.xuat();
		System.out.println("Co phan trong cong ty: " + this.coPhanTrongCty + "%");
		System.out.println("Luong thang: " + this.tinhLuongThang() + "d");
	}
	
	public float getCoPhanTrongCty() {
		return coPhanTrongCty;
	}

	public void setCoPhanTrongCty(float coPhanTrongCty) {
		this.coPhanTrongCty = coPhanTrongCty;
	}
	
	
}
