package modell;
public class StudentExam {
	int id;
	String hoten;
	String diachi; 
	float diemcong; 
	String truongCS; 
	String truongTH;
	String ngaysinh; 
	String gioitinh; 
	String cumthi; 
	String phongthi; 
	float diemanh; 
	float diemtoan; 
	float diemvan;
	
	public StudentExam(String hoten, String diachi, float diemcong, String truongCS, String truongTH, String ngaysinh,
			String gioitinh, String cumthi, String phongthi, float diemanh, float diemtoan, float diemvan) {
		super();
		this.hoten = hoten;
		this.diachi = diachi;
		this.diemcong = diemcong;
		this.truongCS = truongCS;
		this.truongTH = truongTH;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.cumthi = cumthi;
		this.phongthi = phongthi;
		this.diemanh = diemanh;
		this.diemtoan = diemtoan;
		this.diemvan = diemvan;
	}

	public StudentExam(int id, String hoten, String diachi, float diemcong, String truongCS, String truongTH,
			String ngaysinh, String gioitinh, String cumthi, String phongthi, float diemanh, float diemtoan,
			float diemvan) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.diachi = diachi;
		this.diemcong = diemcong;
		this.truongCS = truongCS;
		this.truongTH = truongTH;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.cumthi = cumthi;
		this.phongthi = phongthi;
		this.diemanh = diemanh;
		this.diemtoan = diemtoan;
		this.diemvan = diemvan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public float getDiemcong() {
		return diemcong;
	}

	public void setDiemcong(float diemcong) {
		this.diemcong = diemcong;
	}

	public String getTruongCS() {
		return truongCS;
	}

	public void setTruongCS(String truongCS) {
		this.truongCS = truongCS;
	}

	public String getTruongTH() {
		return truongTH;
	}

	public void setTruongTH(String truongTH) {
		this.truongTH = truongTH;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getCumthi() {
		return cumthi;
	}

	public void setCumthi(String cumthi) {
		this.cumthi = cumthi;
	}

	public String getPhongthi() {
		return phongthi;
	}

	public void setPhongthi(String phongthi) {
		this.phongthi = phongthi;
	}

	public float getDiemanh() {
		return diemanh;
	}

	public void setDiemanh(float diemanh) {
		this.diemanh = diemanh;
	}

	public float getDiemtoan() {
		return diemtoan;
	}

	public void setDiemtoan(float diemtoan) {
		this.diemtoan = diemtoan;
	}

	public float getDiemvan() {
		return diemvan;
	}

	public void setDiemvan(float diemvan) {
		this.diemvan = diemvan;
	}

	public float diemTong() {
		return  getDiemtoan()*2 + getDiemvan() *2 + getDiemanh(); 
	}
}
