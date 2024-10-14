package Dominio;

public class Huesped {
    private int idHuesped;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String tipo_documento;
    private int num_documento;
    private String fecha_nacimiento;
    private String telefono;
    private String pais;

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(int num_documento) {
        this.num_documento = num_documento;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Huesped(int idHuesped, String nombre, String aPaterno, String aMaterno, String tipo_documento, int num_documento, String fecha_nacimiento, String telefono, String pais) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.pais = pais;
    }
    public Huesped(String nombre, String aPaterno, String aMaterno, String tipo_documento, int num_documento, String fecha_nacimiento, String telefono, String pais) {
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Huespedes{" +
                "idHuesped='" + idHuesped + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aPaterno='" + aPaterno + '\'' +
                ", aMaterno='" + aMaterno + '\'' +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", num_documento=" + num_documento +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", telefono=" + telefono +
                ", pais='" + pais + '\'' +
                '}';
    }
}
