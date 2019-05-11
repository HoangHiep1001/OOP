package create;

public class Person extends ThucThe{
    private String chucVu;

    public Person() {
    }

    public Person(String chucVu, String DinhDanh, String NhanHienThi, String MoTa, NguonGoc NguonGoc) {
        super(DinhDanh, NhanHienThi, MoTa, NguonGoc);
        this.setChucVu(chucVu);
    }

    @Override
    public void ThemVaoDB() {
        //To change body of generated methods, choose Tools | Templates.
    }

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
    
    
}
