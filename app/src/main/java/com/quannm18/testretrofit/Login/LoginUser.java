package com.quannm18.testretrofit.Login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginUser {
    @SerializedName("_id")
    private String id;
    @SerializedName("hoTen")
    private String hoTen;
    @SerializedName("taiKhoan")
    private String taiKhoan;
    @SerializedName("matKhau")
    private String matKhau;
    @SerializedName("ngaySinh")
    private String ngaySinh;
    @SerializedName("queQuan")
    private String queQuan;
    @SerializedName("role")
    private String role;

    public LoginUser(String id, String hoTen, String taiKhoan, String matKhau, String ngaySinh, String queQuan, String role) {
        this.id = id;
        this.hoTen = hoTen;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.role = role;
    }

    public LoginUser(List<LoginUser> body) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", queQuan='" + queQuan + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
