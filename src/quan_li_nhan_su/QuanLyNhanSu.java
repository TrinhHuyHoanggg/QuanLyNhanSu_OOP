package quan_li_nhan_su;

import java.util.Arrays;
import java.util.Scanner;

public class QuanLyNhanSu {
	public static void waitForCont() {
			Scanner scan = new Scanner(System.in);
            System.out.printf("\n\tPress C to Continue...");
            boolean pressed = false;
            String entered = "";
            while(!pressed) {
                    entered=scan.next();
                    if((entered.equals("C"))||entered.equals("c"))
                        pressed=true;
            }
      }
	
	
	//*******************************Phan bo cac nhan vien cho truong phong*******************************
	public static void phanBoNhanVien(NhanVien nv[]) {
		Scanner scan = new Scanner(System.in);
		String tempMsnv;
		
		for(int i = 0; i < nv.length; i++) {
			if(nv[i].getId() == "nvt") {
				System.out.println("(1). Ten: " + nv[i].getTenNhanVien());
				System.out.println("(2). MSNV: " + nv[i].getMsNhanVien());
				System.out.println("(?). Them/ Thay doi truong phong? ");
				System.out.print("(?). Neu co thi nhap msnv truong phong, khong thi nhap ky tu bat ki: ");
				tempMsnv = scan.next();
				for(int j = 0; j < nv.length; j++) {
					if(nv[j].getId() == "tp" && nv[j].getMsNhanVien().equals(tempMsnv)) {
						((NhanVienThuong) nv[i]).setTruongPhong((TruongPhong) nv[j]);
						((TruongPhong) nv[j]).increaseSoLuongNv();
						System.out.println("(!). Da them truong phong: " + nv[j].getTenNhanVien() + "...");
						break;
					}
				}
			}
		}
	}

	//***********************************************Them nhan vien***********************************************
	public static NhanVien[] themNhanVien(NhanVien nhanVien[], int k) {
		Scanner scan = new Scanner(System.in);
		NhanVien []tempArr = new NhanVien[nhanVien.length + 1];
		NhanVien newNhanVien;
		if(k == 1)
			newNhanVien = new GiamDoc();
		else if(k == 2)
			newNhanVien = new TruongPhong();
		else
			newNhanVien = new NhanVienThuong();
		newNhanVien.nhap();
		System.arraycopy(nhanVien, 0, tempArr, 0, nhanVien.length);
		tempArr[nhanVien.length] = newNhanVien;
		return tempArr;
	}
	
	//***********************************************Xoa nhan vien***********************************************
	public static NhanVien[] xoaNhanVien(NhanVien nhanVien[], String msnv) {
		NhanVien []tempArr = new NhanVien[nhanVien.length - 1];
		for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getMsNhanVien().equals(msnv) && nhanVien[i].getId().equals("gd")) {
				for(int j = i; j < nhanVien.length - 1; j++) {
					nhanVien[j] = nhanVien[j + 1];
				}
				break;
			}
			else if(nhanVien[i].getMsNhanVien().equals(msnv) && nhanVien[i].getId().equals("tp")) {
				for(int k = 0; k < nhanVien.length; k++) {
					if(nhanVien[k].getId().equals("nvt") && ((NhanVienThuong) nhanVien[k]).getTruongPhong() != null)
						if(((NhanVienThuong) nhanVien[k]).getTruongPhong().getMsNhanVien().equals(msnv))
							((NhanVienThuong) nhanVien[k]).setTruongPhong(null);	
				}
				for(int j = i; j < nhanVien.length - 1; j++) {
					nhanVien[j] = nhanVien[j + 1];
				}
				break;
			}
			else if(nhanVien[i].getMsNhanVien().equals(msnv) && nhanVien[i].getId().equals("nvt")) {
				if(((NhanVienThuong) nhanVien[i]).getTruongPhong() != null) {
					for(int k = 0; k < nhanVien.length; k++) {
						if(((NhanVienThuong) nhanVien[i]).getTruongPhong() == nhanVien[k]) {
							((TruongPhong) nhanVien[k]).decreaseSoLuongNv();
						}
					}
				}
				for(int j = i; j < nhanVien.length - 1; j++) {
					nhanVien[j] = nhanVien[j + 1];
				}
				break;
			}
		}
		
		System.arraycopy(nhanVien, 0, tempArr, 0, tempArr.length);
		
		return tempArr; 
	}
 
	//*****************************************Xuat nhan vien*****************************************
	public static void xuatNhanVien(NhanVien nhanVien[]) {
		for(int i = 0; i < nhanVien.length; i++) {
			nhanVien[i].xuat();
		}
	}
	
	
	//*****************************************Tinh tong luong cua cong ty*****************************************
	public static double tongLuongToanCty(NhanVien nhanVien[]) {
		double tongLuong = 0;
		for(int i = 0; i < nhanVien.length; i++) {
			tongLuong = tongLuong + nhanVien[i].getLuongThang();
		}
		return tongLuong;
	}

	//********************************Tim nhan vien thuong co so luong cao nhat********************************
	public static void timNvLuongMax(NhanVien nhanVien[]) {
		double luongMax = 0;
		for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getId().equals("nvt")) {
				luongMax = (nhanVien[i].getLuongThang() > luongMax) ? nhanVien[i].getLuongThang() : luongMax;
			}
		}
		for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getLuongThang() == luongMax && nhanVien[i].getId().equals("nvt"))
				nhanVien[i].xuat();
		}
	}
	
	//********************************Tim truong phong co so luong nhan vien nhieu nhat********************************
	public static void timTpCoNvMax(NhanVien nhanVien[]) {
		int numNhanVienMax = 0;
		for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getId().equals("tp")) {
				numNhanVienMax = (((TruongPhong) nhanVien[i]).getSoLuongNv() > numNhanVienMax) ? ((TruongPhong) nhanVien[i]).getSoLuongNv() : numNhanVienMax;
			}
		}
	for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getId().equals("tp"))
				if(((TruongPhong) nhanVien[i]).getSoLuongNv() == numNhanVienMax)
					nhanVien[i].xuat();
	}
	}
	
	//*****************************************Sap xep theo ten*****************************************
	public static void sapXepNvName(NhanVien nhanVien[]) {
		NhanVien[] tempNhanVien = new NhanVien[nhanVien.length];
		System.arraycopy(nhanVien, 0, tempNhanVien, 0, nhanVien.length);
		Arrays.sort(tempNhanVien);
		System.out.println("=================SAP XEP THEO TEN=================");
		xuatNhanVien(tempNhanVien);
	}
	
	//***************************************Sap xep theo luong***************************************
	public static void sapXepNvLuong(NhanVien nhanVien[]) {
		NhanVien[] tempNhanVien = new NhanVien[nhanVien.length];
		System.arraycopy(nhanVien, 0, tempNhanVien, 0, nhanVien.length);
		for(int i = 0; i < tempNhanVien.length - 1; i++) {
			for(int j = i + 1; j < tempNhanVien.length; j++) {
				if(tempNhanVien[i].getLuongThang() < tempNhanVien[j].getLuongThang()) {
					NhanVien temp = tempNhanVien[i];
					tempNhanVien[i] = tempNhanVien[j];
					tempNhanVien[j] = temp;
				}
			}
		}
		System.out.println("=================SAP XEP THEO LUONG=================");
		xuatNhanVien(tempNhanVien);
	}
	
	//*******************************Tim giam doc co co phan nhieu nhat*******************************
	public static void giamDocCoPhanMax(NhanVien nhanVien[]) {
		float coPhanMax = 0;
		for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getId().equals("gd"))
				coPhanMax = (((GiamDoc) nhanVien[i]).getCoPhanTrongCty() > coPhanMax) ? ((GiamDoc) nhanVien[i]).getCoPhanTrongCty() : coPhanMax;
		}
		for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getId().equals("gd"))
				if(((GiamDoc) nhanVien[i]).getCoPhanTrongCty() == coPhanMax)
					nhanVien[i].xuat();
		}
	}
	
	public static void thuNhapGd(NhanVien nhanVien[], CongTy cty) {
		double loiNhuan = cty.getDoanhThuThang() - tongLuongToanCty(nhanVien);
		double thuNhap;
		for(int i = 0; i < nhanVien.length; i++) {
			if(nhanVien[i].getId().equals("gd")) {
				thuNhap = ((GiamDoc) nhanVien[i]).getLuongThang() + ((GiamDoc) nhanVien[i]).getCoPhanTrongCty() * loiNhuan;
				nhanVien[i].xuat();
				System.out.println("Thu nhap cua " + nhanVien[i].getTenNhanVien() + " la: " + thuNhap + "d.");
			}
		}
	}
	
	
	
	//****************************************************Ham main****************************************************
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CongTy ctyTemp = new CongTy();
		boolean nhapDuLieu = false;
			
		ctyTemp.nhapInfoCongTy();
		System.out.print("(?). Nhap so luong nhan vien cong ty: ");
		int soNhanVien = scan.nextInt();
		scan.nextLine();
		NhanVien[] nhanVien = new NhanVien[soNhanVien];
		
				
		while(true) {
			System.out.println("===========================MENU===========================");
			System.out.println("(1).  Nhap thong tin cong ty " + ctyTemp.getTenCongTy() + ": ");
			System.out.println("(2).  Phan bo nhan vien vo truong phong.");
			System.out.println("(3).  Them, xoa thong tin nhan vien.");
			System.out.println("(4).  Xuat ra thong tin nhan vien.");
			System.out.println("(5).  Xuat tong luong cong ty.");
			System.out.println("(6).  Tim nhan vien co luong cao nhat.");
			System.out.println("(7).  Tim truong phong co so luong nv nhieu nhat.");
			System.out.println("(8).  Sap xep nhan vien.");
			System.out.println("(9).  Tim giam doc co so luong co phan nhieu nhat.");
			System.out.println("(10). Xuat thu nhap tung giam doc.");
			System.out.println("==========================================================");
			System.out.print("(?). Ban muon lam gi? ");
			int key = scan.nextInt();
			scan.nextLine();

			switch(key) {
			case 1:
				System.out.println("=================NHAP THONG TIN NHAN VIEN=================");
				for(int i = 0; i < soNhanVien; i++) {
					System.out.println("(!). Nhap thong tin cho nhan vien thu " + (i + 1) + ": ");
					System.out.print("(?). Loai nhan vien: (1. Giam doc) (2. Truong phong) (3. Nhan vien thuong): ");
					int choose = scan.nextInt();
					if(choose < 1 || choose > 3) {
						do {
							System.out.print("(?). Ban chon lai: ");
							choose = scan.nextInt();
						} while(choose < 1 || choose > 3);
					}
					if(choose == 1) {
						nhanVien[i] = new GiamDoc();
					}
					else if(choose == 2) {
						nhanVien[i] = new TruongPhong();
					}
					else if(choose == 3) {
						nhanVien[i] = new NhanVienThuong();
					}
					
					nhanVien[i].nhap();				
				}
				nhapDuLieu = true;
				System.out.println("NHAP THANH CONG====================================");
				xuatNhanVien(nhanVien);
				waitForCont();
				break;
			case 2:
				if(nhapDuLieu == false) {
					System.out.println("(!). Ban can phai nhap du lieu.");
					break;
				}
				System.out.println("==============PHAN BO NHAN VIEN CHO TRUONG PHONG==============");
				phanBoNhanVien(nhanVien);
				waitForCont();
				break;
			case 3:
				if(nhapDuLieu == false) {
					System.out.println("(!). Ban can phai nhap du lieu.");
					break;
				}
				System.out.println("===================THEM/ XOA NHAN VIEN===================");
				System.out.printf("\t(1). Them nhan vien.\n");
				System.out.printf("\t(2). Xoa nhan vien.\n");
				System.out.printf("(?). Ban muon lam gi? ");
				int choose = scan.nextInt();
				scan.nextLine();
				if(choose == 1) {
					System.out.print("(?). Loai nhan vien: (1. Giam doc) (2. Truong phong) (3. Nhan vien thuong): ");
					int choose_2 = scan.nextInt();
					if(choose_2 < 1 || choose_2 > 3) {
						do {
							System.out.print("(?). Ban chon lai: ");
							choose_2 = scan.nextInt();
						} while(choose_2 < 1 || choose_2 > 3);
					}
					nhanVien = themNhanVien(nhanVien, choose_2);
					System.out.println("(!). Da them nhan vien...");
				}
				else if(choose == 2) {
					System.out.print("(?). Nhap msnv: ");
					String tempMsnv = scan.nextLine();
					nhanVien = xoaNhanVien(nhanVien, tempMsnv);
					System.out.println("(!). Da xoa nhan vien...");
				}
				else {
					System.out.println("(!). Yeu cau khong hop le.");
				}
				waitForCont();
				break;
			case 4:
				if(nhapDuLieu == false) {
					System.out.println("(!). Ban can phai nhap du lieu.");
					break;
				}
				System.out.println("=================XUAT THONG TIN NHAN VIEN=================");
				xuatNhanVien(nhanVien);
				waitForCont();
				break;
			case 5:
				if(nhapDuLieu == false) {
					System.out.println("(!). Ban can phai nhap du lieu.");
					break;
				}
				System.out.println("==========================================================");
				System.out.println("(!). Tong luong toan bo nhan vien cty: " + tongLuongToanCty(nhanVien) + "d");
				System.out.println("==========================================================");
				waitForCont();
				break;
			case 6:
				if(nhapDuLieu == false) {
					System.out.println("(!). Ban can phai nhap du lieu.");
					break;
				}
				System.out.println("=================NHAN VIEN THUONG CO LUONG CAO NHAT=================");
				timNvLuongMax(nhanVien);
				waitForCont();
				break;
			case 7:
				if(nhapDuLieu == false) {
					System.out.println("(!). Ban can phai nhap du lieu.");
					break;
				}
				System.out.println("=================NHAN VIEN THUONG CO LUONG CAO NHAT=================");
				timTpCoNvMax(nhanVien);
				waitForCont();
				break;
			case 8:
				System.out.println("=================SAP XEP NHAN VIEN=================");
				System.out.println("(1). Sap xep theo ten.");
				System.out.println("(2). Sap xep theo luong giam dan.");
				int choose_sort = scan.nextInt();
				if(choose_sort < 1 || choose_sort > 2) {
					do {
						System.out.print("(?). Ban chon lai: ");
						choose_sort = scan.nextInt();
					} while(choose_sort < 1 || choose_sort > 2);
				}
				if(choose_sort == 1)
					sapXepNvName(nhanVien);
				else
					sapXepNvLuong(nhanVien);
				waitForCont();
				break;
			case 9:
				System.out.println("=================GIAM DOC CO CO PHAN NHIEU NHAT=================");
				giamDocCoPhanMax(nhanVien);
				waitForCont();
				break;
			case 10:
				System.out.println("=================THU NHAP CAC GIAM DOC=================");
				thuNhapGd(nhanVien, ctyTemp);
				waitForCont();
				break;
			}
		}
	}
	
}
